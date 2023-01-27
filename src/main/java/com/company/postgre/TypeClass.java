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
@Table(name = "type_class")
@AttributeOverride(name = "id", column = @Column(name = "type_class_id"))
public class TypeClass extends PostgreEntity{

  private String name;

}
