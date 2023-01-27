package com.company.postgre;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "discipline")
@AttributeOverride(name = "id", column = @Column(name = "discipline_id"))
public class Discipline extends PostgreEntity{
  @ToString.Exclude
  @ManyToOne
  @JoinColumn(name = "department_id")
  private Department department;
  private String name;
  @Column(name = "short_name")
  private String shortName;
  private transient Long dkafId;
  @Column(name = "id_from_source")
  private Long idFromSource;
}
