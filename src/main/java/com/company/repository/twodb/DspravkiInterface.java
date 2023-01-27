package com.company.repository.twodb;

import com.company.mysql.DPropuski;
import com.company.mysql.DSpravki;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DspravkiInterface extends JpaRepository<DSpravki, Long> {
}
