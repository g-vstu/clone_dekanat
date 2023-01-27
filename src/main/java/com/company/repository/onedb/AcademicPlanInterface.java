package com.company.repository.onedb;

import com.company.postgre.AcademicPlan;
import com.company.postgre.Area;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademicPlanInterface extends JpaRepository<AcademicPlan, Long> {
    AcademicPlan findByGroupNameAndSemesterNumber(String groupName, Long semesterNumber);

    AcademicPlan findByIdFromSource(Long idFromSource);
}
