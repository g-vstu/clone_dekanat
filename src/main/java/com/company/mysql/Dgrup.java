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
@Table(name = "Dgrup")
@AttributeOverride(name = "idFromSource", column = @Column(name = "dgrup_id"))
public class Dgrup extends MySqlEntity{
  @Column(name = "dfak_id")
  private long dfak_id;
  private long dmetodist_id;
  @Column(name = "gr")
  private String name;
  private long dspec_id;
  @Column(name = "data1")
  private java.sql.Date year_start;
  @Column(name = "data2")
  private java.sql.Date year_end;

}
