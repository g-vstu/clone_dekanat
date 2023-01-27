package com.company.postgre;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "statement")
@AttributeOverride(name = "id", column = @Column(name = "statement_id"))
public class Statement extends PostgreEntity{
  @ManyToOne
  @JoinColumn(name = "load_id")
  @ToString.Exclude
  private Load load;
  @ManyToOne
  @JoinColumn(name = "student_id")
  private Student student;
  private String grade;
  private java.sql.Date issue_date;
  private java.sql.Date delivery_date;
  private transient String fio_stud;
  private transient long duchplan_id;
  private transient String delo;
  private transient long dstudent_id;
  private transient String gr;
  private transient Integer N_semestra;
  private transient long ndis;
  private transient long nekz;
  private transient long idFromSource;
}
