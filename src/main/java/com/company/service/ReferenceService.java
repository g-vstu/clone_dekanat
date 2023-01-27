package com.company.service;

import com.company.mapper.Mapper;
import com.company.mysql.DSpravki;
import com.company.postgre.Pass;
import com.company.postgre.PassReason;
import com.company.postgre.Reference;
import com.company.postgre.Student;
import com.company.repository.onedb.PassReasonInterface;
import com.company.repository.onedb.ReferenceInterface;
import com.company.repository.onedb.StudentInterface;
import com.company.repository.twodb.DspravkiInterface;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import javax.naming.Referenceable;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ReferenceService {
    ReferenceInterface referenceInterface;
    DspravkiInterface dspravkiInterface;
    PassReasonInterface passReasonInterface;
    Mapper<Reference, DSpravki> mapper;
    StudentInterface studentInterface;

    public List<Reference> addAll() {
        List<Reference> references = mapper.toPostgres(dspravkiInterface.findAll(), Reference.class);
        references.forEach(reference -> {
            System.out.println(reference.getDelo());
            Student student = studentInterface.findByNumberOfStudentbookAndGroupName(reference.getDelo(), reference.getGr());
            reference.setStudent(student);
            PassReason passReason = passReasonInterface.findByName(reference.getPrichina_prop());
            if (passReason == null) {
                passReason = new PassReason();
                passReason.setName(reference.getPrichina_prop());
                passReason = passReasonInterface.saveAndFlush(passReason);
            }
            reference.setPassReason(passReason);
        });
        return referenceInterface.saveAllAndFlush(references);
    }
}
