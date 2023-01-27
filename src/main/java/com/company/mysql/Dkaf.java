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
@Table(name = "Dkaf")
@AttributeOverride(name = "idFromSource", column = @Column(name = "dkaf_id"))
public class Dkaf extends MySqlEntity{
  @Column(name = "kaf")
  private String name;
  @Column(name = "kaf_kratko")
  private String shortName;
  @Column(name = "aydit")
  private String cabinet_number;
  private long dfak_id;

}
