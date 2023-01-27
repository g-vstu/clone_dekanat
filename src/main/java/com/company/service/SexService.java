package com.company.service;

import com.company.mapper.Mapper;
import com.company.mysql.Dspec;
import com.company.mysql.Dstudent;
import com.company.mysql.Dzvan;
import com.company.postgre.AcademicTitle;
import com.company.postgre.Sex;
import com.company.repository.onedb.AcademicTitleInterface;
import com.company.repository.onedb.SexInterface;
import com.company.repository.twodb.DstudentInterface;
import com.company.repository.twodb.DzvanInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SexService {
    private final DstudentInterface dstudentInterface;
    private final SexInterface sexInterface;
    private final Mapper<Sex, Dstudent> mapper;

    public List<Sex> addAll() {
        return sexInterface.saveAllAndFlush(new HashSet<>(mapper.toPostgres(dstudentInterface.findAll(), Sex.class)));
    }
}
