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
@Table(name = "type_education")
@AttributeOverride(name = "id", column = @Column(name = "type_education_id"))
public class TypeEducation extends PostgreEntity{

  @Column(name = "name")
  private String obuchenie;
  @OneToMany(mappedBy = "typeEducation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @EqualsAndHashCode.Exclude
  private Set<Faculty> faculties;
}
