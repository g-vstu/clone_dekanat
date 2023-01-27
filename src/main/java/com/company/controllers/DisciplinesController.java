package com.company.controllers;

import com.company.electronicjournalDTO.DepartmentsDTO;
import com.company.electronicjournalDTO.DisciplinesDTO;
import com.company.repository.onedb.DepartmentInterface;
import com.company.repository.onedb.DisciplineInterface;
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
@RequestMapping("disciplines")
public class DisciplinesController {

    @Autowired
    private DisciplineInterface disciplineInterface;
    private final ModelMapper modelMapper = new ModelMapper();

    @GetMapping
    public List<DisciplinesDTO> getAll(@RequestParam String query) {
        List<DisciplinesDTO> result = new ArrayList<>();
        if (query.isEmpty()) {
            disciplineInterface.findAll().forEach(discipline ->
                    result.add(modelMapper.map(discipline, (Type) DisciplinesDTO.class)));
        } else {
            disciplineInterface.findAll(disciplineInterface.getSpecifications(query)).forEach(discipline ->
                    result.add(modelMapper.map(discipline, (Type) DisciplinesDTO.class)));
        }
        return result;
    }
}
