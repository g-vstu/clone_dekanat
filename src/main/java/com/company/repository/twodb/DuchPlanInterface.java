package com.company.repository.twodb;

import com.company.mysql.Dekzam;
import com.company.mysql.DuchPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DuchPlanInterface extends JpaRepository<DuchPlan, Long> {
    DuchPlan findByGrAndSemesterNumberAndNdisAndNekz(String gr, Integer sN, Long ndis, Long nekz);
}
