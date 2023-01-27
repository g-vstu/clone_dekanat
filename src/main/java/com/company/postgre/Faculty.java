package com.company.postgre;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "faculty")
@AttributeOverride(name = "id", column = @Column(name = "faculty_id"))
public class Faculty extends PostgreEntity{

  @ToString.Exclude
  @ManyToOne
  @JoinColumn(name = "type_education_id")
  private TypeEducation typeEducation;
  private transient String obuchenie;
  private String name;
  private String short_name;
  private String head_fio;
  private String secretary_fio;
  @Column(name = "id_from_source")
  private Long idFromSource;
  @EqualsAndHashCode.Exclude
  @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<Department> departments;
  @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @EqualsAndHashCode.Exclude
  private Set<Speciality> specialities;
  @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @EqualsAndHashCode.Exclude
  private Set<Methodist> methodists;
}
