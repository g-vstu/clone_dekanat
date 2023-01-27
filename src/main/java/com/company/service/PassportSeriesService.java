package com.company.service;

import com.company.mapper.Mapper;
import com.company.mysql.Dstudent;
import com.company.mysql.Dyo;
import com.company.postgre.EducationalInstitution;
import com.company.postgre.PassportSeries;
import com.company.repository.onedb.EIInterface;
import com.company.repository.onedb.PassportSeriesInterface;
import com.company.repository.twodb.DstudentInterface;
import com.company.repository.twodb.DyoInterface;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PassportSeriesService {
    PassportSeriesInterface passportSeriesInterface;
    DstudentInterface dstudentInterface;
    Mapper<PassportSeries, Dstudent> mapper;

    public List<PassportSeries> addAll() {
        Set<PassportSeries> passportSeries = new HashSet<>(mapper.toPostgres(dstudentInterface.findAll(), PassportSeries.class));
        return passportSeriesInterface.saveAllAndFlush(passportSeries);
    }
}
