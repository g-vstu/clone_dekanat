package com.company.service;

import com.company.mapper.Mapper;
import com.company.mysql.Dgraj;
import com.company.mysql.Dzvan;
import com.company.postgre.AcademicTitle;
import com.company.postgre.Citizenship;
import com.company.repository.onedb.AcademicTitleInterface;
import com.company.repository.onedb.CitizenshipInterface;
import com.company.repository.twodb.DgrajInterface;
import com.company.repository.twodb.DzvanInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CitizenShipService {
    private final CitizenshipInterface citizenshipInterface;
    private final DgrajInterface dgrajInterface;
    private final Mapper<Citizenship, Dgraj> mapper;

    public List<Citizenship> addAll() {
        return citizenshipInterface.saveAllAndFlush(mapper.toPostgres(dgrajInterface.findAll(), Citizenship.class));
    }
}
