package com.company.repository.twodb;

import com.company.mysql.Dekzam;
import com.company.postgre.AttestationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DekzamInterface extends JpaRepository<Dekzam, Long> {
}
