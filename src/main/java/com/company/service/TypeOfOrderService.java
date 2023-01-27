package com.company.service;

import com.company.mapper.Mapper;
import com.company.mysql.Dotklon;
import com.company.postgre.Order;
import com.company.postgre.OrderReason;
import com.company.postgre.TypeOfOrder;
import com.company.repository.onedb.TypeOfOrderInterface;
import com.company.repository.twodb.DotklonInterface;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TypeOfOrderService {
    DotklonInterface dotklonInterface;
    TypeOfOrderInterface typeOfOrderInterface;
    Mapper<TypeOfOrder, Dotklon> mapper;

    public List<TypeOfOrder> addAll() {
        return typeOfOrderInterface.saveAllAndFlush(new HashSet<>(mapper.toPostgres(dotklonInterface.findAll(), TypeOfOrder.class)));
    }
}
