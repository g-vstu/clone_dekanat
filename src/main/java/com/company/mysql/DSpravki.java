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
@Table(name = "DSpravki")
@AttributeOverride(name = "idFromSource", column = @Column(name = "dspravki_id"))
public class DSpravki extends MySqlEntity{

  private String delo;
  private String gr;
  @Column(name = "data_s")
  private java.sql.Date certificate_start_date;
  @Column(name = "data_po")
  private java.sql.Date certificate_end_date;
  private String prichina_prop;

}
