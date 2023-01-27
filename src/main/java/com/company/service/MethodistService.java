package com.company.service;

import com.company.mapper.Mapper;
import com.company.mysql.Dfak;
import com.company.mysql.Dmetodist;
import com.company.postgre.Faculty;
import com.company.postgre.Methodist;
import com.company.postgre.Speciality;
import com.company.postgre.TypeEducation;
import com.company.repository.onedb.FacultyInterface;
import com.company.repository.onedb.MethodistInterface;
import com.company.repository.twodb.DfakInterface;
import com.company.repository.twodb.DmetodistInterface;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class MethodistService {
    DmetodistInterface dmetodistInterface;
    FacultyInterface facultyInterface;
    DfakInterface dfakInterface;
    MethodistInterface methodistInterface;
    Mapper<Methodist, Dmetodist> mapper;

    public List<Methodist> addAll() {
        List<Methodist> methodists = mapper.toPostgres(dmetodistInterface.findAll(), Methodist.class);
        methodists.forEach(methodist -> {
            Dfak dfak = dfakInterface.findById(methodist.getDfak_id()).get();
            Faculty faculty = facultyInterface.findByName(dfak.getName());
            methodist.setFaculty(faculty);
        });
        return methodistInterface.saveAllAndFlush(methodists);
    }
}
