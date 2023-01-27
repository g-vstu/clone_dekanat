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
@Table(name = "locality")
@AttributeOverride(name = "id", column = @Column(name = "locality_id"))
public class Locality extends PostgreEntity{

  private String name;
  @ToString.Exclude
  @OneToMany(mappedBy = "locality", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @EqualsAndHashCode.Exclude
  private Set<Student> students;
}
