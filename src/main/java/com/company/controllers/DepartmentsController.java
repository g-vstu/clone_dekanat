package com.company.controllers;

import com.company.electronicjournalDTO.AcademicTitlesDTO;
import com.company.electronicjournalDTO.DepartmentsDTO;
import com.company.repository.onedb.AcademicTitleInterface;
import com.company.repository.onedb.DepartmentInterface;
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
@RequestMapping("departments")
public class DepartmentsController {

    @Autowired
    private DepartmentInterface departmentInterface;
    private final ModelMapper modelMapper = new ModelMapper();

    @GetMapping
    public List<DepartmentsDTO> getAll(@RequestParam String query) {
        List<DepartmentsDTO> result = new ArrayList<>();
        if (query.isEmpty()) {
            departmentInterface.findAll().forEach(department ->
                    result.add(modelMapper.map(department, (Type) DepartmentsDTO.class)));
        } else {
            departmentInterface.findAll(departmentInterface.getSpecifications(query)).forEach(department ->
                    result.add(modelMapper.map(department, (Type) DepartmentsDTO.class)));
        }
        return result;
    }
}
