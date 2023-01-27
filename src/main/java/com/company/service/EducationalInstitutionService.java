package com.company.service;

import com.company.mapper.Mapper;
import com.company.mysql.Dfak;
import com.company.mysql.Dkaf;
import com.company.mysql.Dyo;
import com.company.postgre.AcademicTitle;
import com.company.postgre.Department;
import com.company.postgre.EducationalInstitution;
import com.company.postgre.Faculty;
import com.company.repository.onedb.DepartmentInterface;
import com.company.repository.onedb.EIInterface;
import com.company.repository.onedb.FacultyInterface;
import com.company.repository.twodb.DfakInterface;
import com.company.repository.twodb.DkafInterface;
import com.company.repository.twodb.DyoInterface;
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
public class EducationalInstitutionService {

    EIInterface eiInterface;
    DyoInterface dyoInterface;
    Mapper<EducationalInstitution, Dyo> mapper;

    public List<EducationalInstitution> addAll() {
        return eiInterface.saveAllAndFlush(mapper.toPostgres(dyoInterface.findAll(), EducationalInstitution.class));
    }
}
