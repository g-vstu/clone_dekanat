package com.company.electronicjournalDTO;

import com.company.postgre.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class TeachersDTO extends AbstractDTO {
    private String surname;
    private String name;
    private String patronymic;
    @JsonProperty("departmentIdFromSource")
    private Long departmentIdFromSource;
    @JsonProperty("academicTitleIdFromSource")
    private Long academicTitleIdFromSource;
}
