package com.company.repository.onedb;

import com.company.postgre.Methodist;
import com.company.postgre.Pass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassInterface extends JpaRepository<Pass, Long> {
}
