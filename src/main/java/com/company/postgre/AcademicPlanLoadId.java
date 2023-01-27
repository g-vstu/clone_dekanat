package com.company.postgre;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
@NoArgsConstructor
public class AcademicPlanLoadId implements Serializable {
    @Column(name = "academic_plan_id")
    private Long academicPlanId;
    @Column(name = "load_id")
    private Long loadId;
}
