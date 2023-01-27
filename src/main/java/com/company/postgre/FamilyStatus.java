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
@Table(name = "family_status")
@AttributeOverride(name = "id", column = @Column(name = "family_status_id"))
public class FamilyStatus extends PostgreEntity{

  private String name;

}
