package com.company.mysql;

import lombok.Data;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "Dyo")
@AttributeOverride(name = "idFromSource", column = @Column(name = "dyo_id"))
public class Dyo extends MySqlEntity{
  @Column(name = "nameYo")
  private String name;
  @Column(name = "nameYo1")
  private String shortName;

}
