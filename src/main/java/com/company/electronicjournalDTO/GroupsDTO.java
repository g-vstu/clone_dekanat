package com.company.electronicjournalDTO;

import com.company.postgre.DepartmentDTO;
import com.company.postgre.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class GroupsDTO extends AbstractDTO{
    String name;
    Long departmentIdFromSource;
}
