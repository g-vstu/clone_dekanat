package com.company.postgre;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "citizenship")
@AttributeOverride(name = "id", column = @Column(name = "citizenship_id"))
public class Citizenship extends PostgreEntity{

  private String name;

}
