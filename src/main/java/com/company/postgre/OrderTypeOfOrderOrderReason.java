package com.company.postgre;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "order_type_of_order_order_reason")
@AttributeOverride(name = "id", column = @Column(name = "order_type_of_order_order_reason_id"))
public class OrderTypeOfOrderOrderReason extends PostgreEntity{
    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "type_of_order_id")
    private TypeOfOrder typeOfOrder;
    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "order_reason_id")
    private OrderReason orderReason;
    @Column(name = "start_date")
    private Date dataS;
    @Column(name = "end_date")
    private Date dataPo;
    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "orderTypeOfOrderOrderReasons", fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    private Set<Student> students;
}
