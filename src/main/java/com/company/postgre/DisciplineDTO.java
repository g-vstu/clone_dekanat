package com.company.postgre;

import lombok.Data;

@Data
public class DisciplineDTO {
    String name;
    String shortName;
    DepartmentDTO department;
}
