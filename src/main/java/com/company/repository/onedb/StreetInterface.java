package com.company.repository.onedb;

import com.company.postgre.StreetAddress;
import com.company.postgre.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreetInterface extends JpaRepository<StreetAddress, Long> {
    StreetAddress findByStreetName(String streetName);
}
