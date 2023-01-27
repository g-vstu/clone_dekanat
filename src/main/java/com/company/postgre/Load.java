package com.company.postgre;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "load")
@AttributeOverride(name = "id", column = @Column(name = "load_id"))
public class Load extends PostgreEntity{
  @ManyToOne
  @JoinColumn(name = "attestation_type_id")
  private AttestationType attestationType;
  private transient long attestationTypeId;
  @Column(name = "hours_number")
  private double hoursNumber;
  @Column(name = "credit_units")
  private double creditUnits;
  @ManyToOne
  @JoinColumn(name = "discipline_id")
  private Discipline discipline;
  private transient long disciplineId;
  @ToString.Exclude
  @ManyToMany(cascade = CascadeType.ALL, mappedBy = "loads", fetch = FetchType.LAZY)
  @EqualsAndHashCode.Exclude
  private Set<AcademicPlan> academicPlans;
  @EqualsAndHashCode.Exclude
  @OneToMany(mappedBy = "load", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<Statement> statements;
}
