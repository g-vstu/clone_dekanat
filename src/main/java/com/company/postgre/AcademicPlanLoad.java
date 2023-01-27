package com.company.postgre;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "academic_plan_load")
public class AcademicPlanLoad {
    @EmbeddedId
    private AcademicPlanLoadId id = new AcademicPlanLoadId();
    @ToString.Exclude
    @ManyToOne
    @MapsId("academicPlanId")
    @JoinColumn(name = "academic_plan_id")
    private AcademicPlan academicPlan;
    @ToString.Exclude
    @ManyToOne
    @MapsId("loadId")
    @JoinColumn(name = "load_id")
    private Load load;
}
