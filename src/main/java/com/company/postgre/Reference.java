package com.company.postgre;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "reference")
@AttributeOverride(name = "id", column = @Column(name = "reference_id"))
public class Reference extends PostgreEntity{
  @ManyToOne
  @JoinColumn(name = "student_id")
  private Student student;
  private java.sql.Date certificate_start_date;
  private java.sql.Date certificate_end_date;
  @ManyToOne
  @JoinColumn(name = "pass_reason_id")
  private PassReason passReason;

  private transient String gr;
  private transient String delo;
  private transient String prichina_prop;

}
