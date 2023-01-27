package com.company.postgre;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "student_group")
@AttributeOverride(name = "id", column = @Column(name = "group_id"))
public class Group extends PostgreEntity{
  @ToString.Exclude
  @ManyToOne
  @JoinColumn(name = "specialty_id")
  private Speciality speciality;
  private transient long dspec_id;
  @ToString.Exclude
  @ManyToOne
  @JoinColumn(name = "department_id")
  private Department department;
  private transient long department_id;
  @ToString.Exclude
  @ManyToOne
  @JoinColumn(name = "methodist_id")
  private Methodist methodist;
  private transient long dmetodist_id;
  private String name;
  @Column(name = "id_from_source")
  private Long idFromSource;
  private java.sql.Date year_start;
  private java.sql.Date year_end;
  @Column(name = "course")
  private Integer course;

}
