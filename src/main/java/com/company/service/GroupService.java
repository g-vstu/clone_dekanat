package com.company.service;

import com.company.mapper.Mapper;
import com.company.mysql.Dfak;
import com.company.mysql.Dgrup;
import com.company.mysql.Dmetodist;
import com.company.mysql.Dspec;
import com.company.postgre.*;
import com.company.repository.onedb.*;
import com.company.repository.twodb.DfakInterface;
import com.company.repository.twodb.DgroupInterface;
import com.company.repository.twodb.DmetodistInterface;
import com.company.repository.twodb.DpecInterface;
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
public class GroupService {
    DepartmentInterface departmentInterface;
    FacultyInterface facultyInterface;
    DfakInterface dfakInterface;
    DgroupInterface dgroupInterface;
    MethodistInterface methodistInterface;
    DmetodistInterface dmetodistInterface;
    DpecInterface dpecInterface;
    SpecialityInterface specialityInterface;
    GroupInterface groupInterface;
    Mapper<Group, Dgrup> mapper;

    public List<Group> addAll() {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<GroupDTO> groupDTOS = new ArrayList<>();
        restTemplate.exchange("http://localhost:8084/groups/search?q=", HttpMethod.GET, null, new ParameterizedTypeReference<List<GroupDTO>>() {}).
                getBody().stream().forEach(entry -> groupDTOS.add(objectMapper.convertValue(entry, GroupDTO.class)));
        List<Group> groups = mapper.toPostgres(dgroupInterface.findAll(), Group.class);
        AtomicReference<String> DSN = new AtomicReference<>("123");
        groups.forEach(group -> {
            Dmetodist dmetodist = dmetodistInterface.findById(group.getDmetodist_id()).get();
            Methodist methodist = new ArrayList<>(methodistInterface.findByFio(dmetodist.getFio())).get(0);
            group.setMethodist(methodist);
            Dspec dspec = dpecInterface.findById(group.getDspec_id()).orElse(null);
            Speciality speciality = null;
            if (dspec != null) {
                Faculty faculty = facultyInterface.findByName(dfakInterface.findById(dspec.getDfak_id()).get().getName());
                try {
                    speciality = specialityInterface.findByShortNameAndNameAndSpecialtyCodeAndFacultyId(dspec.getShortName(), dspec.getName(), dspec.getSpecialtyCode(), faculty.getId());
                } catch (Exception e) {
                    System.out.println(dspec.getShortName());
                }
            }
            group.setSpeciality(speciality);
            if (groupDTOS.stream().anyMatch(groupDTO -> {
                Boolean b = groupDTO.getName().equals(group.getName());
                if (b) {
                    if(groupDTO.getDepartment()==null){return false;}
                    DSN.set(groupDTO.getDepartment().getDisplayName());
                    return true;
                } else {
                    return false;
                }
            })) {
                Department department = departmentInterface.findByShortName(DSN.get());
                group.setDepartment(department);
            }
        });
        return groupInterface.saveAllAndFlush(groups);
    }
}
