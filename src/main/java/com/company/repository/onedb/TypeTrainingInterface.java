package com.company.repository.onedb;

import com.company.postgre.TypeEducation;
import com.company.postgre.TypeTraining;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeTrainingInterface extends JpaRepository<TypeTraining, Long> {
    TypeTraining findByName(String name);
}
