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
@Table(name = "DPrichPrik")
@AttributeOverride(name = "idFromSource", column = @Column(name = "Nprich"))
public class DPrichPrik extends MySqlEntity{
  @Column(name = "prichprik")
  private String name;
  @Column(name = "namestolbca")
  private String name2;

}
