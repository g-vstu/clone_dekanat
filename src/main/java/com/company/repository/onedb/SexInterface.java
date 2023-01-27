package com.company.repository.onedb;

import com.company.postgre.Sex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SexInterface extends JpaRepository<Sex, Long> {
    Sex findByPol(String name);
}
