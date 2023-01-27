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
@Table(name = "district")
@AttributeOverride(name = "id", column = @Column(name = "district_id"))
public class District extends PostgreEntity{

  private String name;
  private String postcode;
  @ToString.Exclude
  @OneToMany(mappedBy = "district", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @EqualsAndHashCode.Exclude
  private Set<Student> students;
}
