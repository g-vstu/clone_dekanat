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
@Table(name = "educational_institution")
@AttributeOverride(name = "id", column = @Column(name = "educational_institution_id"))
public class EducationalInstitution extends PostgreEntity{

  private String name;
  @Column(name = "short_name")
  private String shortName;

}
