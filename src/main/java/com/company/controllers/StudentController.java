package com.company.controllers;

import com.company.electronicjournalDTO.DepartmentsDTO;
import com.company.electronicjournalDTO.ForeignLanguagesDTO;
import com.company.electronicjournalDTO.GroupsDTO;
import com.company.electronicjournalDTO.StudentsDTO;
import com.company.repository.onedb.LanguageInterface;
import com.company.repository.onedb.StudentInterface;
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
@RequestMapping("students")
public class StudentController {

    @Autowired
    private StudentInterface studentInterface;
    private final ModelMapper modelMapper = new ModelMapper();

    @GetMapping
    public List<StudentsDTO> getAll(@RequestParam String query) {
        List<StudentsDTO> result = new ArrayList<>();
        if (query.isEmpty()) {
            studentInterface.findAll().forEach(student ->
                    result.add(modelMapper.map(student, (Type) StudentsDTO.class)));
        } else {
            studentInterface.findAll(studentInterface.getSpecifications(query)).forEach(student ->
                    result.add(modelMapper.map(student, (Type) StudentsDTO.class)));
        }
        return result;
    }
}
