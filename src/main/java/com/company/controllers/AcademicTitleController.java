package com.company.controllers;

import com.company.electronicjournalDTO.AcademicTitlesDTO;
import com.company.electronicjournalDTO.GroupsDTO;
import com.company.repository.onedb.AcademicTitleInterface;
import com.company.repository.onedb.GroupInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("academic_titles")
public class AcademicTitleController {

    @Autowired
    private AcademicTitleInterface academicTitleInterface;
    private final ModelMapper modelMapper = new ModelMapper();

    @GetMapping
    public List<AcademicTitlesDTO> getAll(@RequestParam String query) {
        List<AcademicTitlesDTO> result = new ArrayList<>();
        if (query.isEmpty()) {
            academicTitleInterface.findAll().forEach(academicTitle ->
                    result.add(modelMapper.map(academicTitle, (Type) AcademicTitlesDTO.class)));
        } else {
            academicTitleInterface.findAll(academicTitleInterface.getSpecifications(query)).forEach(academicTitle ->
                    result.add(modelMapper.map(academicTitle, (Type) AcademicTitlesDTO.class)));
        }
        return result;
    }
}
