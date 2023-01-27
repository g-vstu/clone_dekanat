package com.company.repository.onedb;

import com.company.postgre.Citizenship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitizenshipInterface extends JpaRepository<Citizenship, Long> {
    Citizenship findByName(String name);
}
