package com.company.repository.twodb;

import com.company.mysql.Ddiscip;
import com.company.postgre.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DdiscipInterface extends JpaRepository<Ddiscip, Long> {
}
