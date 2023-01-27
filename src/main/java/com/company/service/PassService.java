package com.company.service;

import com.company.mapper.Mapper;
import com.company.mysql.*;
import com.company.postgre.*;
import com.company.repository.onedb.*;
import com.company.repository.twodb.DPropInterface;
import com.company.repository.twodb.DdiscipInterface;
import com.company.repository.twodb.DkafInterface;
import com.company.repository.twodb.DprepodInterface;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PassService {
    PassInterface passInterface;
    DPropInterface dPropInterface;
    DepartmentInterface departmentInterface;
    DkafInterface dkafInterface;
    ReferenceInterface referenceInterface;
    StudentInterface studentInterface;
    DisciplineInterface disciplineInterface;
    DdiscipInterface ddiscipInterface;
    TypeClassInterface typeClassInterface;
    TeacherInterface teacherInterface;
    DprepodInterface dprepodInterface;
    Mapper<Pass, DPropuski> mapper;

    public List<Pass> addAll() {
        List<Pass> passes = mapper.toPostgres(dPropInterface.findAll(), Pass.class);
        AtomicInteger i = new AtomicInteger();
        passes.forEach(pass -> {
            Discipline discipline = disciplineInterface.findByIdFromSource(pass.getNdis());
            pass.setDiscipline(discipline);
            Department department = discipline.getDepartment();
            pass.setDepartment(department);
            String type_class = "";
            switch (pass.getVid_nagr()) {
                case "практ.": {
                    type_class = "Практическая работа";
                    break;
                }
                case "лабор.": {
                    type_class = "Лабораторная работа";
                    break;
                }
            }
            TypeClass typeClass = typeClassInterface.findByName(type_class);
            pass.setType_class(typeClass);
            pass.setStudent(studentInterface.findByNumberOfStudentbookAndGroupName(pass.getDelo(), pass.getGr()));
            if (pass.getStudent()!=null) {
                List<Reference> references = referenceInterface.findByStudentReferences(pass.getStudent().getNumberOfStudentbook(),
                        pass.getPass_date());
                Reference reference = references.isEmpty() ? null : references.get(0);
                pass.setReference(reference);
            }
            //System.out.println(dprepod.getName() + dprepod.getSurname() + dprepod.getPatronymic());
            Teacher teacher = teacherInterface.findByIdFromSource(pass.getNprep());
            pass.setTeacher(teacher);
            pass.setWorked(pass.getDate_worked() == null ? false : true);
            System.out.println(i.incrementAndGet());
        });
        return passInterface.saveAllAndFlush(passes);
    }
}
