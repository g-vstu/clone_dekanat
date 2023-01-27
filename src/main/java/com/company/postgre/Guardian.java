package com.company.postgre;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "guardian")
@AttributeOverride(name = "id", column = @Column(name = "guardian_id"))
public class Guardian extends PostgreEntity{
    private String fio;
    @ManyToOne
    @JoinColumn(name = "sex_id")
    private Sex sex;
    private String phone;
    @Column(name = "work_place")
    private String workPlace;
    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "guardians", fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    private Set<Student> students;
}
