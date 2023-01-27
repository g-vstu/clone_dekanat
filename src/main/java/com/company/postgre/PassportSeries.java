package com.company.postgre;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "passport_series")
@AttributeOverride(name = "id", column = @Column(name = "passport_series_id"))
public class PassportSeries extends PostgreEntity{
  @Column(name = "name")
  private String passportSerija;

}
