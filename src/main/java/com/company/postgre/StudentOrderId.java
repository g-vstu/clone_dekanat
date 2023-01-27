package com.company.postgre;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Embeddable
@NoArgsConstructor
public class StudentOrderId implements Serializable {
    @Column(name = "student_id")
    private Long studentId;
    @Column(name = "order_type_of_order_order_reason_id")
    private Long orderTypeOfOrderOrderReasonId;
}
