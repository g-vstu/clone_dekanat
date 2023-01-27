package com.company.repository.onedb;

import com.company.postgre.Country;
import com.company.postgre.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountyInterface extends JpaRepository<Country, Long> {
    Country findByName(String name);
}
