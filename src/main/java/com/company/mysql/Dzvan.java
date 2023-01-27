package com.company.mysql;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Dzvan")
@AttributeOverride(name = "idFromSource", column = @Column(name = "dzvan_id"))
public class Dzvan extends MySqlEntity{
  @Column(name = "uch_zvan")
  private String uchZvan;
  private String cena;

}
