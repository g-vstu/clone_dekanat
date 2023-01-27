package com.company.repository.onedb;

import com.company.postgre.OrderReason;
import com.company.postgre.OrderTypeOfOrderOrderReason;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface OrderTypeOfOrderOrderReasonInterface extends JpaRepository<OrderTypeOfOrderOrderReason, Long> {
    OrderTypeOfOrderOrderReason findByOrder_PrikazOtklonAndOrder_DataPrikAndDataSAndDataPoAndTypeOfOrder_VidPrikAndOrderReason_IdFromSource(String pO, Date dP, Date startDate, Date endDate, String vP, Long orderReasonIFS);
}
