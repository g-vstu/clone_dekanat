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
@Table(name = "Dotklon")
@AttributeOverride(name = "idFromSource", column = @Column(name = "dotklon_id"))
public class Dotklon extends MySqlEntity{

  private String delo;
  @Column(name = "vid_prik")
  private String vidPrik;
  @Column(name = "Nprich")
  private Long nprich;
  private String fam;
  @Column(name = "fam_new")
  private String famNew;
  private String gr;
  @Column(name = "prikaz_otklon")
  private String prikazOtklon;
  @Column(name = "data_prik")
  private java.sql.Timestamp dataPrik;
  @Column(name = "data_s")
  private java.sql.Timestamp dataS;
  @Column(name = "data_po")
  private java.sql.Timestamp dataPo;
  @Column(name = "gr_new")
  private String grNew;

}
