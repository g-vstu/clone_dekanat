package com.company.postgre;

import lombok.Data;

@Data
public class TeacherDTO {
    String name;
    String surname;
    String patronymic;
    DepartmentDTO department;
}
