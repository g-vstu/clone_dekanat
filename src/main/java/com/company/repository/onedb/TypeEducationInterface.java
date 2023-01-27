package com.company.repository.onedb;

import com.company.postgre.TypeEducation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeEducationInterface extends JpaRepository<TypeEducation, Long> {
    TypeEducation findByObuchenie(String name);
}
