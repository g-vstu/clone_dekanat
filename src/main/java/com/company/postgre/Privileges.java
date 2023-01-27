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
@Table(name = "privileges")
@AttributeOverride(name = "id", column = @Column(name = "privileges_id"))
public class Privileges extends PostgreEntity{

  private String name;
}
