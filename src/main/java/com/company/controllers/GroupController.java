package com.company.controllers;

import com.company.electronicjournalDTO.DepartmentsDTO;
import com.company.electronicjournalDTO.GroupsDTO;
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

@RestController
@RequestMapping("groups")
public class GroupController {

    @Autowired
    private GroupInterface groupService;
    private final ModelMapper modelMapper = new ModelMapper();

    @GetMapping
    public List<GroupsDTO> getAll(@RequestParam String query) {
        List<GroupsDTO> result = new ArrayList<>();
        if (query.isEmpty()) {
            groupService.findAll().forEach(group ->
                    result.add(modelMapper.map(group, (Type) GroupsDTO.class)));
        } else {
            groupService.findAll(groupService.getSpecifications(query)).forEach(group ->
                    result.add(modelMapper.map(group, (Type) GroupsDTO.class)));
        }
        return result;
    }
}
