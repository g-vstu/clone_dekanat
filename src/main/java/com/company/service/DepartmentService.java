package com.company.service;

import com.company.mapper.Mapper;
import com.company.mysql.Dfak;
import com.company.mysql.Dkaf;
import com.company.postgre.AcademicTitle;
import com.company.postgre.Department;
import com.company.postgre.Faculty;
import com.company.repository.onedb.DepartmentInterface;
import com.company.repository.onedb.FacultyInterface;
import com.company.repository.twodb.DfakInterface;
import com.company.repository.twodb.DkafInterface;
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
public class DepartmentService {
    DepartmentInterface departmentInterface;
    DkafInterface dkafInterface;
    FacultyInterface facultyInterface;
    DfakInterface dfakInterface;
    Mapper<Department, Dkaf> mapper;

    public List<Department> addAll() {
        List<Department> departments = mapper.toPostgres(dkafInterface.findAll(), Department.class);
        departments.forEach(department -> {
            Dfak dfak = dfakInterface.findById(department.getDfak_id()).get();
            Faculty faculty = facultyInterface.findByName(dfak.getName());
            department.setFaculty(faculty);
        });
        return departmentInterface.saveAllAndFlush(departments);
    }
}
