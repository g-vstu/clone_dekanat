package com.company.service;

import com.company.mapper.Mapper;
import com.company.mysql.Dzvan;
import com.company.postgre.AcademicTitle;
import com.company.repository.onedb.AcademicTitleInterface;
import com.company.repository.twodb.DzvanInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AcademicTitleService {
    private final AcademicTitleInterface academicTitleInterface;
    private final DzvanInterface dzvanInterface;
    private final Mapper<AcademicTitle, Dzvan> mapper;

    public List<AcademicTitle> addAll() {
        return academicTitleInterface.saveAllAndFlush(mapper.toPostgres(dzvanInterface.findAll(), AcademicTitle.class));
    }
}
