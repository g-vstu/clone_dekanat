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
@Table(name = "dvedom")
@AttributeOverride(name = "idFromSource", column = @Column(name = "dvedom_id"))
public class Dvedom extends MySqlEntity{

  private long duchplan_id;
  @Column(name = "data_ved")
  private java.sql.Date issue_date;
  @Column(name = "data_sdachi")
  private java.sql.Date delivery_date;
  @Column(name = "ocenka_sim")
  private String grade;
  private String fio_stud;
  private long dstudent_id;
  private String gr;
  private Integer N_semestra;
  private long ndis;
  private long nekz;
  private String delo;

}
