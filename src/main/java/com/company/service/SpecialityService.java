package com.company.service;

import com.company.mapper.Mapper;
import com.company.mysql.DSumStip;
import com.company.mysql.Dfak;
import com.company.mysql.Dspec;
import com.company.postgre.Faculty;
import com.company.postgre.Sex;
import com.company.postgre.Speciality;
import com.company.repository.onedb.FacultyInterface;
import com.company.repository.onedb.SpecialityInterface;
import com.company.repository.twodb.DfakInterface;
import com.company.repository.twodb.DpecInterface;
import com.company.repository.twodb.DsumStipInterface;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SpecialityService {
    SpecialityInterface specialityInterface;
    DpecInterface dpecInterface;
    DfakInterface dfakInterface;
    FacultyInterface facultyInterface;
    DsumStipInterface dsumStipInterface;
    Mapper<Speciality, Dspec> mapper;

    public List<Speciality> addAll() {
        List<Speciality> specialities = mapper.toPostgres(dpecInterface.findAll(), Speciality.class);
        specialities.forEach(speciality -> {
            Dfak dfak = dfakInterface.findById(speciality.getDfak_id()).get();
            Faculty faculty = facultyInterface.findByName(dfak.getName());
            speciality.setFaculty(faculty);
            Double minGrant = dsumStipInterface.findAll().stream().filter(dSumStip ->
                    dSumStip.getDfak_id().equals(dfak.getIdFromSource())).map(DSumStip::getSum_stip).mapToDouble(value -> Double.parseDouble(value)).min().orElse(0.0);
            speciality.setMin_grant(minGrant);
        });
        return specialityInterface.saveAllAndFlush(specialities);
    }
}
