package com.company.postgre;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "teacher")
@AttributeOverride(name = "id", column = @Column(name = "teacher_id"))
public class Teacher extends PostgreEntity{
  @ToString.Exclude
  @ManyToOne
  @JoinColumn(name = "department_id")
  private Department department;
  //private transient long departmentId;
  private String surname;
  private String name;
  private String patronymic;
  @ToString.Exclude
  @ManyToOne
  @JoinColumn(name = "academic_title_id")
  private AcademicTitle academicTitle;
  //private transient long academicTitleId;
  private String photo;
  private transient String uchZvan;
  @Column(name = "id_from_source")
  private Long idFromSource;
}
