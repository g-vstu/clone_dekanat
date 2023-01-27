package com.company.postgre;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "type_of_order")
@AttributeOverride(name = "id", column = @Column(name = "type_of_order_id"))
public class TypeOfOrder extends PostgreEntity{
  @Column(name = "name")
  private String vidPrik;

  @ToString.Exclude
  @OneToMany(mappedBy = "typeOfOrder", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @EqualsAndHashCode.Exclude
  private Set<OrderTypeOfOrderOrderReason> orderTypeOfOrderOrderReasons;
}
