package com.company.repository.onedb;

import com.company.postgre.AcademicPlanLoad;
import com.company.postgre.AcademicTitle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademicPlanLoadInterface extends JpaRepository<AcademicPlanLoad, Long> {
}
