package com.company.service;

import com.company.mapper.Mapper;
import com.company.mysql.Dotklon;
import com.company.postgre.*;
import com.company.repository.onedb.OrderInterface;
import com.company.repository.onedb.OrderReasonInterface;
import com.company.repository.onedb.StudentInterface;
import com.company.repository.onedb.TypeOfOrderInterface;
import com.company.repository.twodb.DPrichPrikInterface;
import com.company.repository.twodb.DotklonInterface;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class OrderService {
    StudentInterface studentInterface;
    DotklonInterface dotklonInterface;
    DPrichPrikInterface dPrichPrikInterface;
    OrderInterface orderInterface;
    OrderReasonInterface orderReasonInterface;
    TypeOfOrderInterface typeOfOrderInterface;

    Mapper<Order, Dotklon> mapper;

    public List<Order> addAll() {
        new HashSet<>(mapper.toPostgres(dotklonInterface.findAll(), Order.class)).forEach(order -> orderInterface.saveAndFlush(order));
        return null;
    }
}
