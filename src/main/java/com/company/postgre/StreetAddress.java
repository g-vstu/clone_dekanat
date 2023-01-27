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
@Table(name = "street_address")
@AttributeOverride(name = "id", column = @Column(name = "street_address_id"))
public class StreetAddress extends PostgreEntity{
  @Column(name = "street_name")
  private String streetName;
  @ToString.Exclude
  @OneToMany(mappedBy = "street_address", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @EqualsAndHashCode.Exclude
  private Set<Student> students;
}
