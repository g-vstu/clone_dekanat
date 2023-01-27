package com.company.postgre;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "academic_plan")
@AttributeOverride(name = "id", column = @Column(name = "academic_plan_id"))
public class AcademicPlan extends PostgreEntity{
  @ManyToOne
  @JoinColumn(name = "group_id")
  private Group group;
  @ToString.Exclude
  private transient String gr;
  @Column(name = "semester_number")
  private long semesterNumber;
  @Column(name = "id_from_source")
  private Long idFromSource;
  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinTable(name = "academic_plan_load", joinColumns = {@JoinColumn(name = "academic_plan_id")}, inverseJoinColumns = {
          @JoinColumn(name = "load_id")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"academic_plan_id", "load_id"})})
  @JsonIgnore
  @EqualsAndHashCode.Exclude
  private Set<Load> loads;
  @ToString.Exclude
  private transient long nekz;
  @ToString.Exclude
  private transient long ndis;
  @ToString.Exclude
  private transient double clock;
  @ToString.Exclude
  private transient double creditUnits;
}
