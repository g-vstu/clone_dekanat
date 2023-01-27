package com.company.mysql;

import lombok.Data;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "Dfak")
@AttributeOverride(name = "idFromSource", column = @Column(name = "dfak_id"))
public class Dfak extends MySqlEntity{

  @Column(name = "fak_name")
  String name;
  @Column(name = "fak")
  String short_name;
  @Column(name = "dekan")
  String head_fio;
  @Column(name = "sekretar")
  String secretary_fio;
  @Column(name = "obuchenie")
  String obuchenie;

}
