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
@Table(name = "dekzam")
@AttributeOverride(name = "idFromSource", column = @Column(name = "nekz"))
public class Dekzam extends MySqlEntity{

  @Column(name = "nameekzam")
  private String name;
  @Column(name = "vidoc")
  private String assessmentType;
}
