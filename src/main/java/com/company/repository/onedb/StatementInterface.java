package com.company.repository.onedb;

import com.company.postgre.AcademicPlan;
import com.company.postgre.Statement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatementInterface extends JpaRepository<Statement, Long> {
}
