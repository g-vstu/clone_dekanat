package com.company.repository.onedb;

import com.company.postgre.Area;
import com.company.postgre.Country;
import com.company.postgre.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaInterface extends JpaRepository<Area, Long> {
    Area findByName(String name);
}
