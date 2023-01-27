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
@Table(name = "duchplan")
@AttributeOverride(name = "idFromSource", column = @Column(name = "duchplan_id"))
public class DuchPlan extends MySqlEntity{

  private String gr;
  @Column(name = "N_semestra")
  private long semesterNumber;
  private long nekz;
  private long ndis;
  private double clock;
  @Column(name = "zach_ed")
  private double creditUnits;

}
