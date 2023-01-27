package com.company.postgre;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "department")
@AttributeOverride(name = "id", column = @Column(name = "department_id"))
public class Department extends PostgreEntity{
  @ManyToOne
  @ToString.Exclude
  @JoinColumn(name = "faculty_id")
  private Faculty faculty;
  private String name;
  @Column(name = "short_name")
  private String shortName;
  private String head_fio;
  private String alternate_fio_first;
  private String alternate_fio_second;
  private String cabinet_number;
  @Column(name = "id_from_source")
  private Long idFromSource;
  private transient long dfak_id;
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<Group> groups;
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<Teacher> teachers;
  @ToString.Exclude
  @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @EqualsAndHashCode.Exclude
  private Set<Discipline> disciplines;
}
