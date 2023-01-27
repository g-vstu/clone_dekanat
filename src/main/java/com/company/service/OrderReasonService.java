package com.company.service;

import com.company.mapper.Mapper;
import com.company.mysql.DPrichPrik;
import com.company.postgre.Order;
import com.company.postgre.OrderReason;
import com.company.postgre.TypeOfOrder;
import com.company.repository.onedb.OrderReasonInterface;
import com.company.repository.twodb.DPrichPrikInterface;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class OrderReasonService {
    DPrichPrikInterface dPrichPrikInterface;
    OrderReasonInterface orderReasonInterface;
    Mapper<OrderReason, DPrichPrik> mapper;

    public List<OrderReason> addAll() {
        List<OrderReason> orderReasons = mapper.toPostgres(dPrichPrikInterface.findAll(), OrderReason.class);
        return orderReasonInterface.saveAllAndFlush(orderReasons);
    }
}
