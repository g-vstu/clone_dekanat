package com.company.postgre;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "order1")
@AttributeOverride(name = "id", column = @Column(name = "order_id"))
public class Order extends PostgreEntity{
  @Column(name = "order_number")
  private String prikazOtklon;
  private transient Long nprich;
  @Column(name = "creation_date")
  private Date dataPrik;

  @ToString.Exclude
  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @EqualsAndHashCode.Exclude
  private Set<OrderTypeOfOrderOrderReason> orderTypeOfOrderOrderReasons;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Order order = (Order) o;
    return Objects.equals(prikazOtklon, order.prikazOtklon) &&
            Objects.equals(dataPrik, order.dataPrik);
  }

  @Override
  public int hashCode() {
    return Objects.hash(prikazOtklon, dataPrik);
  }

  private transient String fam;
  private transient Date dataS;
  private transient Date dataPo;
  private transient String gr;
  private transient String vidPrik;
  private transient String delo;
  private transient String famNew;
  private transient String grNew;
}
