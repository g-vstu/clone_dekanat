package com.company.electronicjournalDTO;

import com.company.postgre.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class StudentsDTO extends AbstractDTO {
    private String surname;
    private String name;
    private String patronymic;
    @JsonProperty("groupIdFromSource")
    private Long groupIdFromSource;
    @JsonProperty("foreignLanguageIdFromSource")
    private Long foreignLanguageIdFromSource;
}
