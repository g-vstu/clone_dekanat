package com.company.postgre;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "pass_reason")
@AttributeOverride(name = "id", column = @Column(name = "pass_reason_id"))
public class PassReason extends PostgreEntity{

  private String name;

}
