package com.company.service;

import com.company.mapper.Mapper;
import com.company.mysql.Dfak;
import com.company.mysql.Dstudent;
import com.company.postgre.Faculty;
import com.company.postgre.Sex;
import com.company.postgre.TypeEducation;
import com.company.repository.onedb.FacultyInterface;
import com.company.repository.onedb.SexInterface;
import com.company.repository.onedb.TypeEducationInterface;
import com.company.repository.twodb.DfakInterface;
import com.company.repository.twodb.DstudentInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class FacultyService {
    private final FacultyInterface facultyInterface;
    private final DfakInterface dfakInterface;
    private final Mapper<Faculty, Dfak> mapper;
    private final Mapper<TypeEducation, Dfak> mapperTypeEd;
    private final TypeEducationInterface typeEducationInterface;

    public List<Faculty> addAll() {
        List<Faculty> faculties = mapper.toPostgres(dfakInterface.findAll(), Faculty.class);
        faculties.forEach(faculty -> {
            if (faculty.getObuchenie() != null) {
                TypeEducation typeEducation = typeEducationInterface.findByObuchenie(faculty.getObuchenie());
                if (typeEducation == null) {
                    typeEducation = new TypeEducation();
                    typeEducation.setObuchenie(faculty.getObuchenie());
                    typeEducation = typeEducationInterface.saveAndFlush(typeEducation);
                }
                faculty.setTypeEducation(typeEducation);
            }
        });
        return facultyInterface.saveAllAndFlush(faculties);
    }
}
