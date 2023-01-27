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
@Table(name = "mother")
@AttributeOverride(name = "id", column = @Column(name = "mother_id"))
public class Mother extends PostgreEntity{

  private String surname;
  private String name;
  private String patronymic;
  private String phone;
  private String workPlace;

}
