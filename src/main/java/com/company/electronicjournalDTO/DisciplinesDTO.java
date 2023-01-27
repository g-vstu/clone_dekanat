package com.company.electronicjournalDTO;

import com.company.postgre.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class DisciplinesDTO extends AbstractDTO {
    private String name;
    private Long departmentIdFromSource;
}
