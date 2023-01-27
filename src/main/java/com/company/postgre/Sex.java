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
@Table(name = "sex")
@AttributeOverride(name = "id", column = @Column(name = "sex_id"))
public class Sex extends PostgreEntity {

  @Column(name = "name")
  private String pol;

}
