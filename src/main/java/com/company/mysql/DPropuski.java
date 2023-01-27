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
@Table(name = "DPropuski")
@AttributeOverride(name = "idFromSource", column = @Column(name = "dpropuski_id"))
public class DPropuski extends MySqlEntity{

  private long dkaf_id;
  private long ndis;
  private String gr;
  private String uch_zvan;
  private String vid_nagr;
  private String delo;
  @Column(name = "data")
  private java.sql.Date pass_date;
  @Column(name = "clock")
  private double number_missed_hours;
  @Column(name = "summa")
  private String price;
  @Column(name = "data_opl")
  private java.sql.Date mining_closing_date;
  private long nprep;
  @Column(name = "data_erip")
  private java.sql.Date erip_date_payment;
  @Column(name = "data_otrab")
  private java.sql.Date date_worked;
  @Column(name = "data_vidachi")
  private java.sql.Date processing_date_issue;

}
