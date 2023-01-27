package com.company.controllers;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentDTO {
    String surname;
    String name;
    String patronymic;
    String groupName;
    String[] birthday;
    String foreignLanguageName;
}
