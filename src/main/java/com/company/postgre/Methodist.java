package com.company.postgre;

import com.company.mysql.MySqlEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "methodist")
@AttributeOverride(name = "id", column = @Column(name = "methodist_id"))
public class Methodist extends PostgreEntity {
  @ToString.Exclude
  @ManyToOne
  @JoinColumn(name = "faculty_id")
  private Faculty faculty;
  private transient long dfak_id;
  //@Embedded
  //private FullName fullName;
  private String fio;
  @EqualsAndHashCode.Exclude
  @OneToMany(mappedBy = "methodist", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<Group> groups;
}
