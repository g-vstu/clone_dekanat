package com.company.repository.twodb;

import com.company.mysql.DPropuski;
import com.company.postgre.Reference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DPropInterface extends JpaRepository<DPropuski, Long> {
}
