package com.company.mysql;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Dspec")
@AttributeOverride(name = "idFromSource", column = @Column(name = "dspec_id"))
public class Dspec extends MySqlEntity{

  private long dfak_id;
  @Column(name = "shifr_spec")
  private String specialtyCode;
  @Column(name = "namespec")
  private String name;
  @Column(name = "spec_kratko")
  private String shortName;
  private String namespec1;
  private String namespec2;

}
