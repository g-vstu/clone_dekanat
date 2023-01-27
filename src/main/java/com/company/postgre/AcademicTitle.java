package com.company.postgre;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "academic_title")
@AttributeOverride(name = "id", column = @Column(name = "academic_title_id"))
public class AcademicTitle extends PostgreEntity{

  @Column(name = "name")
  private String uchZvan;
  @Column(name = "price")
  private Double cena;
  @Column(name = "id_from_source")
  private Long idFromSource;
  @EqualsAndHashCode.Exclude
  @OneToMany(mappedBy = "academicTitle", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<Teacher> teachers;

}
