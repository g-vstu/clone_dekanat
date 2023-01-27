package com.company.postgre;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "student_order_type_of_order_order_reason")
public class StudentOrderTypeOfOrderOrderReason {
    @EmbeddedId
    private StudentOrderId id = new StudentOrderId();
    @ToString.Exclude
    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")

    private Student student;
    @ToString.Exclude
    @ManyToOne
    @MapsId("orderTypeOfOrderOrderReasonId")
    @JoinColumn(name = "order_type_of_order_order_reason_id")
    private OrderTypeOfOrderOrderReason orderTypeOfOrderOrderReason;
}
