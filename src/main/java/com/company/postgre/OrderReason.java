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
@Table(name = "Order_reason")
@AttributeOverride(name = "id", column = @Column(name = "order_reason_id"))
public class OrderReason extends PostgreEntity{

  private String name;
  private String name2;
  @Column(name = "id_from_source")
  private Long idFromSource;

}
