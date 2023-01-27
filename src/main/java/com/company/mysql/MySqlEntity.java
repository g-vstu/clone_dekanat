package com.company.mysql;

import com.company.postgre.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public class MySqlEntity {

    @Id
    @ReadOnlyProperty
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFromSource;

}