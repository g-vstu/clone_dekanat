package com.company.repository.twodb;

import com.company.mysql.Dzvan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DzvanInterface extends JpaRepository<Dzvan, Long> {
}
