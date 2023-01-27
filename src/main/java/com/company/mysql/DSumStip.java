package com.company.mysql;

import lombok.Data;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "DSumStip")
@AttributeOverride(name = "idFromSource", column = @Column(name = "dsumstip_id"))
public class DSumStip extends MySqlEntity{

  private Long dfak_id;
  private String spec_kratko;
  private String shifr_spec;
  private java.sql.Timestamp data_s;
  private double sr_ball1;
  private double sr_ball2;
  private double koef;
  private String sum_stip;
}
