package com.company.controllers;

import com.company.electronicjournalDTO.DepartmentsDTO;
import com.company.electronicjournalDTO.DisciplinesDTO;
import com.company.electronicjournalDTO.FacultiesDTO;
import com.company.electronicjournalDTO.ForeignLanguagesDTO;
import com.company.repository.onedb.DisciplineInterface;
import com.company.repository.onedb.LanguageInterface;
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
@RequestMapping("foreign_languages")
public class ForeignLanguageController {

    @Autowired
    private LanguageInterface languageInterface;
    private final ModelMapper modelMapper = new ModelMapper();

    @GetMapping
    public List<ForeignLanguagesDTO> getAll(@RequestParam String query) {
        List<ForeignLanguagesDTO> result = new ArrayList<>();
        if (query.isEmpty()) {
            languageInterface.findAll().forEach(language ->
                    result.add(modelMapper.map(language, (Type) ForeignLanguagesDTO.class)));
        } else {
            languageInterface.findAll(languageInterface.getSpecifications(query)).forEach(language ->
                    result.add(modelMapper.map(language, (Type) ForeignLanguagesDTO.class)));
        }
        return result;
    }
}
