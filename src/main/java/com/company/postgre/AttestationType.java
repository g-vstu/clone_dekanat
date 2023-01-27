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
@Table(name = "attestation_type")
@AttributeOverride(name = "id", column = @Column(name = "attestation_type_id"))
public class AttestationType extends PostgreEntity{

  private String name;
  @Column(name = "assessment_type")
  private String assessmentType;
  @Column(name = "id_from_source")
  private Long idFromSource;
}
