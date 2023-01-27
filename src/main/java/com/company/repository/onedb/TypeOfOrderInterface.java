package com.company.repository.onedb;

import com.company.postgre.Teacher;
import com.company.postgre.TypeOfOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeOfOrderInterface extends JpaRepository<TypeOfOrder, Long> {
    TypeOfOrder findByVidPrik(String vidPrik);
}
