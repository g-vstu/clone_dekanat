package com.company.repository.onedb;

import com.company.postgre.FamilyStatus;
import com.company.postgre.Sex;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyStatusInterface extends JpaRepository<FamilyStatus, Long> {
    FamilyStatus findByName(String name);
}
