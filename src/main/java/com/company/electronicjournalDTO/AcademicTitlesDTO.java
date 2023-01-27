package com.company.electronicjournalDTO;

import com.company.postgre.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class AcademicTitlesDTO extends AbstractDTO {
    @JsonProperty("name")
    private String uchZvan;
    @JsonProperty("price")
    private Double cena;
}
