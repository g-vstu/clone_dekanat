package com.company.electronicjournalDTO;

import com.company.postgre.Status;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public class AbstractDTO {
    private Long id;
    @Enumerated(EnumType.STRING)
    private Status status;
    private Long idFromSource;
}
