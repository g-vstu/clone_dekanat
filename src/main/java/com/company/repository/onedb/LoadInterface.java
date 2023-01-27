package com.company.repository.onedb;

import com.company.postgre.AcademicPlan;
import com.company.postgre.Load;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoadInterface extends JpaRepository<Load, Long> {
    Load findByAttestationType_IdFromSourceAndDiscipline_IdFromSourceAndHoursNumberAndCreditUnits(Long atTypeIFS, Long disciplIFS, Double hoursNumber, Double creditUnits);

}
