package com.company.repository.onedb;

import com.company.postgre.Discipline;
import com.company.postgre.TypeClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeClassInterface extends JpaRepository<TypeClass, Long> {
    TypeClass findByName(String name);
}
