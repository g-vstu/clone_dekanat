package com.company.controllers;

import com.company.electronicjournalDTO.AcademicTitlesDTO;
import com.company.electronicjournalDTO.SpecialitiesDTO;
import com.company.repository.onedb.AcademicTitleInterface;
import com.company.repository.onedb.SpecialityInterface;
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
@RequestMapping("specialities")
public class SpecialityController {

    @Autowired
    private SpecialityInterface specialityInterface;
    private final ModelMapper modelMapper = new ModelMapper();

    @GetMapping
    public List<SpecialitiesDTO> getAll(@RequestParam String query) {
        List<SpecialitiesDTO> result = new ArrayList<>();
        if (query.isEmpty()) {
            specialityInterface.findAll().forEach(speciality ->
                    result.add(modelMapper.map(speciality, (Type) SpecialitiesDTO.class)));
        } else {
            specialityInterface.findAll(specialityInterface.getSpecifications(query)).forEach(speciality ->
                    result.add(modelMapper.map(speciality, (Type) SpecialitiesDTO.class)));
        }
        return result;
    }
}
