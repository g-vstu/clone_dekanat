package com.company.repository.onedb;

import com.company.postgre.Privileges;
import com.company.postgre.Sex;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivelegesInterface extends JpaRepository<Privileges, Long> {
    Privileges findByName(String name);
}
