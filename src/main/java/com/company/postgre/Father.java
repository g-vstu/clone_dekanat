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
@Table(name = "father")
@AttributeOverride(name = "id", column = @Column(name = "father_id"))
public class Father extends PostgreEntity{

  private String surname;
  private String name;
  private String patronymic;
  private String phone;
  private String workPlace;

}
