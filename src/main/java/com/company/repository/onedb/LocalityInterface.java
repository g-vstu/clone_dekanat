package com.company.repository.onedb;

import com.company.postgre.Locality;
import com.company.postgre.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalityInterface extends JpaRepository<Locality, Long> {
    Locality findByName(String name);
}
