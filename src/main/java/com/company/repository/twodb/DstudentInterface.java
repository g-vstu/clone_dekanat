package com.company.repository.twodb;

import com.company.mysql.Dstudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DstudentInterface extends JpaRepository<Dstudent, Long> {
}
