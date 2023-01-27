package com.company.repository.onedb;

import com.company.postgre.Pass;
import com.company.postgre.PassReason;
import com.company.postgre.Reference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassReasonInterface extends JpaRepository<PassReason, Long> {
    PassReason findByName(String name);
}
