package com.company.controllers;

import com.company.electronicjournalDTO.DepartmentsDTO;
import com.company.electronicjournalDTO.StudentsDTO;
import com.company.electronicjournalDTO.TeachersDTO;
import com.company.repository.onedb.StudentInterface;
import com.company.repository.onedb.TeacherInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("teachers")
public class TeacherController {

    @Autowired
    private TeacherInterface teacherInterface;
    private final ModelMapper modelMapper = new ModelMapper();

    @GetMapping
    public List<TeachersDTO> getAll(@RequestParam String query) {
        List<TeachersDTO> result = new ArrayList<>();
        if (query.isEmpty()) {
            teacherInterface.findAll().forEach(teacher ->
                    result.add(modelMapper.map(teacher, (Type) TeachersDTO.class)));
        } else {
            teacherInterface.findAll(teacherInterface.getSpecifications(query)).forEach(teacher ->
                    result.add(modelMapper.map(teacher, (Type) TeachersDTO.class)));
        }
        return result;
    }
}
