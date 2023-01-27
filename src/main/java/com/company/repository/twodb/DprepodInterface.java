package com.company.repository.twodb;

import com.company.mysql.Dmetodist;
import com.company.mysql.Dprepod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DprepodInterface extends JpaRepository<Dprepod, Long> {
}
