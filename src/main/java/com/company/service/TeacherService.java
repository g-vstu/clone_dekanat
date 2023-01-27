package com.company.service;

import com.company.mapper.Mapper;
import com.company.mysql.DSumStip;
import com.company.mysql.Dfak;
import com.company.mysql.Dprepod;
import com.company.postgre.*;
import com.company.repository.onedb.AcademicTitleInterface;
import com.company.repository.onedb.DepartmentInterface;
import com.company.repository.onedb.TeacherInterface;
import com.company.repository.twodb.DprepodInterface;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TeacherService {
    DprepodInterface dprepodInterface;
    Mapper<Teacher, Dprepod> mapper;
    DepartmentInterface departmentInterface;
    TeacherInterface teacherInterface;
    AcademicTitleInterface academicTitleInterface;

    public List<Teacher> addAll() {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<TeacherDTO> teacherDTOS = new ArrayList<>();
        restTemplate.exchange("http://localhost:8084/teachers/search?q=", HttpMethod.GET, null, new ParameterizedTypeReference<List<TeacherDTO>>() {}).
                getBody().stream().forEach(entry -> teacherDTOS.add(objectMapper.convertValue(entry, TeacherDTO.class)));
        List<Teacher> teachers = mapper.toPostgres(dprepodInterface.findAll(), Teacher.class);
        teachers.forEach(teacher -> {
            AcademicTitle academicTitle = academicTitleInterface.findByUchZvan(teacher.getUchZvan());
            if (academicTitle != null) {
                teacher.setAcademicTitle(academicTitle);
            }
            AtomicReference<String> DSN = new AtomicReference<>("123");
            if (teacherDTOS.stream().anyMatch(teacherDTO -> {
                Boolean b = teacherDTO.getName().equals(teacher.getName().trim()) && teacherDTO.getSurname().equals(teacher.getSurname().trim()) &&
                        teacherDTO.getPatronymic().equals(teacher.getPatronymic().trim());
                if (b) {
                    if(teacherDTO.getDepartment()==null){return false;}
                    DSN.set(teacherDTO.getDepartment().getDisplayName());
                    return true;
                } else {
                    return false;
                }
            })) {
                Department department = departmentInterface.findByShortName(DSN.get());
                teacher.setDepartment(department);
            }
            teacher.setSurname(teacher.getSurname().trim());
            teacher.setName(teacher.getName().trim());
            teacher.setPatronymic(teacher.getPatronymic().trim());
        });
        return teacherInterface.saveAllAndFlush(teachers);
    }
}













