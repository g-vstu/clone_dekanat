package com.company.repository.onedb;

import com.company.postgre.Pass;
import com.company.postgre.Reference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ReferenceInterface extends JpaRepository<Reference, Long> {

    @Query("SELECT r FROM Reference r WHERE r.student.numberOfStudentbook = :delo " +
            "AND r.certificate_start_date <= :targetDate AND r.certificate_end_date >= :targetDate")
    List<Reference> findByStudentReferences(@Param("delo") String delo, @Param("targetDate") Date targetDate);
}
