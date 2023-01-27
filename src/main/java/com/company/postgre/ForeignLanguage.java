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
@Table(name = "foreign_language")
@AttributeOverride(name = "id", column = @Column(name = "foreign_language_id"))
public class ForeignLanguage extends PostgreEntity {

  private String name;
  @Column(name = "id_from_source")
  private Long idFromSource;

}
