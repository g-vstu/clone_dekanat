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
@Table(name = "speciality")
@AttributeOverride(name = "id", column = @Column(name = "specialty_id"))
public class Speciality extends PostgreEntity {
  @ManyToOne
  @ToString.Exclude
  @JoinColumn(name = "faculty_id")
  private Faculty faculty;
  private transient long dfak_id;
  @Column(name = "specialty_code")
  private String specialtyCode;
  private String name;
  @Column(name = "short_name")
  private String shortName;
  private double min_grant;
  @EqualsAndHashCode.Exclude
  @OneToMany(mappedBy = "speciality", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<Group> groups;
}
