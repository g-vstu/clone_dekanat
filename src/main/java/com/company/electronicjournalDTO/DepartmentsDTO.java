package com.company.electronicjournalDTO;

import com.company.postgre.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class DepartmentsDTO extends AbstractDTO{
    @JsonProperty("displayName")
    //private String name;
    private String shortName;
    private Long facultyIdFromSource;
}
