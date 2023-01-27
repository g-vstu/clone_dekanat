package com.company.repository.onedb;

import com.company.postgre.Order;
import com.company.postgre.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface OrderInterface extends JpaRepository<Order, Long> {
    Order findByPrikazOtklonAndDataPrik(String po, Date dp);
}
