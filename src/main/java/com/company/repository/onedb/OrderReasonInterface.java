package com.company.repository.onedb;

import com.company.postgre.Order;
import com.company.postgre.OrderReason;
import com.company.postgre.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderReasonInterface extends JpaRepository<OrderReason, Long> {
    OrderReason findByIdFromSource(Long idFromSource);
}
