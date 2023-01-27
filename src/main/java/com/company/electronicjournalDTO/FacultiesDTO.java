package com.company.electronicjournalDTO;

import com.company.postgre.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class FacultiesDTO extends AbstractDTO {

    //private String f_display_name;
    @JsonProperty("name")
    private String short_name;
}
