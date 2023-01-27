package com.company.postgre;

import com.company.postgre.PostgreEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "type_training")
@AttributeOverride(name = "id", column = @Column(name = "type_training_id"))
public class TypeTraining extends PostgreEntity {

  private String name;

}
