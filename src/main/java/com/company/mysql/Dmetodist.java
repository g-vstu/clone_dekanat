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
@Table(name = "Dmetodist")
@AttributeOverride(name = "idFromSource", column = @Column(name = "dmetodist_id"))
public class Dmetodist extends MySqlEntity{

  private long dfak_id;
  @Column(name = "metodist")
  private String fio;
}
