package com.company.repository.twodb;

import com.company.mysql.Dinostr;
import org.springframework.data.jpa.repository.JpaRepository;
import sun.rmi.runtime.Log;

public interface DInostrInterface extends JpaRepository<Dinostr, Long> {
}
