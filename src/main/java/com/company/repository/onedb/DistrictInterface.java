package com.company.repository.onedb;

import com.company.postgre.District;
import com.company.postgre.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistrictInterface extends JpaRepository<District, Long> {
    District findByName(String name);
}
