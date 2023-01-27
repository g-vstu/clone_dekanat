package com.company.mysql;

import lombok.Data;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "Dinostr")
@AttributeOverride(name = "idFromSource", column = @Column(name = "dinostr_id"))
public class Dinostr extends MySqlEntity{
  @Column(name = "inostr")
  private String name;

}
