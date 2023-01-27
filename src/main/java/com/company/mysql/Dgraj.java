package com.company.mysql;

import lombok.Data;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "Dgraj")
@AttributeOverride(name = "idFromSource", column = @Column(name = "dgraj_id"))
public class Dgraj extends MySqlEntity{
  @Column(name = "graj")
  private String name;

}
