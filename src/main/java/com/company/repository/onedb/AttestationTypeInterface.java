package com.company.repository.onedb;

import com.company.postgre.AcademicPlan;
import com.company.postgre.AttestationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttestationTypeInterface extends JpaRepository<AttestationType, Long> {
    AttestationType findByIdFromSource(Long idFromSource);
}
