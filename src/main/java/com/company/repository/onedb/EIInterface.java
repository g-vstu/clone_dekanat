package com.company.repository.onedb;

import com.company.mysql.DSumStip;
import com.company.postgre.EducationalInstitution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface EIInterface extends JpaRepository<EducationalInstitution, Long> {
    Set<EducationalInstitution> findByName(String name);
}
