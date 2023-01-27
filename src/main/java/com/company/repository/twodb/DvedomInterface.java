package com.company.repository.twodb;

import com.company.mysql.Dekzam;
import com.company.mysql.Dvedom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DvedomInterface extends JpaRepository<Dvedom, Long> {
}
