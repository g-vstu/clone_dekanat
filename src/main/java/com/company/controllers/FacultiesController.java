package com.company.controllers;

import com.company.electronicjournalDTO.DepartmentsDTO;
import com.company.electronicjournalDTO.DisciplinesDTO;
import com.company.electronicjournalDTO.FacultiesDTO;
import com.company.repository.onedb.DisciplineInterface;
import com.company.repository.onedb.FacultyInterface;
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
@RequestMapping("faculties")
public class FacultiesController {

    @Autowired
    private FacultyInterface facultyInterface;
    private final ModelMapper modelMapper = new ModelMapper();

    @GetMapping
    public List<FacultiesDTO> getAll(@RequestParam String query) {
        List<FacultiesDTO> result = new ArrayList<>();
        if (query.isEmpty()) {
            facultyInterface.findAll().forEach(faculty ->
                    result.add(modelMapper.map(faculty, (Type) FacultiesDTO.class)));
        } else {
            facultyInterface.findAll(facultyInterface.getSpecifications(query)).forEach(faculty ->
                    result.add(modelMapper.map(faculty, (Type) FacultiesDTO.class)));
        }
        return result;
    }
}
