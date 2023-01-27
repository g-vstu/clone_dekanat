package com.company.postgre;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "pass")
@AttributeOverride(name = "id", column = @Column(name = "pass_id"))
public class Pass extends PostgreEntity{
  @ManyToOne
  @JoinColumn(name = "department_id")
  private Department department;
  @ManyToOne
  @JoinColumn(name = "discipline_id")
  private Discipline discipline;
  @ManyToOne
  @JoinColumn(name = "type_class_id")
  private TypeClass type_class;
  @ManyToOne
  @JoinColumn(name = "student_id")
  private Student student;
  @ManyToOne
  @JoinColumn(name = "reference_id")
  private Reference reference;
  private java.sql.Date pass_date;
  private double number_missed_hours;
  private double price;
  private java.sql.Date mining_closing_date;
  @ManyToOne
  @JoinColumn(name = "teacher_id")
  private Teacher teacher;
  private java.sql.Date erip_date_payment;
  private Boolean worked;
  private java.sql.Date date_worked;
  private java.sql.Date processing_date_issue;

  private transient long dkaf_id;
  private transient long ndis;
  private transient String vid_nagr;
  private transient String delo;
  private transient String gr;
  private transient long nprep;
  private transient String uch_zvan;

}
