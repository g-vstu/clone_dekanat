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
@Table(name = "dprepod")
@AttributeOverride(name = "idFromSource", column = @Column(name = "nprep"))
public class Dprepod extends MySqlEntity{
  @Column(name = "fam")
  private String surname;
  @Column(name = "name")
  private String name;
  @Column(name = "otch")
  private String patronymic;
  @Column(name = "uch_zvan")
  private String uchZvan;

}
