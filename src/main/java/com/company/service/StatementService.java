package com.company.service;

import com.company.mapper.Mapper;
import com.company.mysql.DuchPlan;
import com.company.mysql.Dvedom;
import com.company.postgre.Load;
import com.company.postgre.Statement;
import com.company.postgre.Student;
import com.company.repository.onedb.AcademicPlanInterface;
import com.company.repository.onedb.LoadInterface;
import com.company.repository.onedb.StatementInterface;
import com.company.repository.onedb.StudentInterface;
import com.company.repository.twodb.DstudentInterface;
import com.company.repository.twodb.DuchPlanInterface;
import com.company.repository.twodb.DvedomInterface;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class StatementService {
    Mapper<Statement, Dvedom> mapper;
    DvedomInterface dvedomInterface;
    AcademicPlanInterface academicPlanInterface;
    StudentInterface studentInterface;
    LoadInterface loadInterface;
    DuchPlanInterface duchPlanInterface;
    StatementInterface statementInterface;
    DstudentInterface dstudentInterface;

    public List<Statement> addAll() {
        AtomicInteger it = new AtomicInteger();
        List<Statement> statements = mapper.toPostgres(dvedomInterface.findAll(), Statement.class);
        statements.forEach(statement -> {
            DuchPlan duchPlan = null;
            try {
                duchPlan = duchPlanInterface.findById(statement.getDuchplan_id()).get();
            } catch (Exception e){
                try {
                    duchPlan = duchPlanInterface.findByGrAndSemesterNumberAndNdisAndNekz(statement.getGr(), statement.getN_semestra(), statement.getNdis(), statement.getNekz());
                } catch (Exception ignored) {

                }
            }
            Load load = null;
            try {
                load = loadInterface.findByAttestationType_IdFromSourceAndDiscipline_IdFromSourceAndHoursNumberAndCreditUnits(duchPlan.getNekz(),
                        duchPlan.getNdis(), duchPlan.getClock(), duchPlan.getCreditUnits());
            } catch (Exception e) {
                System.out.println(duchPlan);
                System.out.println(statement.getGr() + " " + statement.getN_semestra() + " " + statement.getNdis() + " " + statement.getNekz());
            }
            Student student = studentInterface.findByNumberOfStudentbookAndGroupName(dstudentInterface.findById(statement.getDstudent_id()).get().getNumberOfStudentbook(),
                    dstudentInterface.findById(statement.getDstudent_id()).get().getGr());
            statement.setStudent(student);
            statement.setLoad(load);
            System.out.println(it.incrementAndGet());
            statementInterface.save(statement);
        });
        return statements;
    }
}
