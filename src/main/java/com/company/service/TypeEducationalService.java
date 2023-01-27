package com.company.service;

import com.company.mapper.Mapper;
import com.company.mysql.Dfak;
import com.company.mysql.Dstudent;
import com.company.postgre.Sex;
import com.company.postgre.TypeEducation;
import com.company.repository.onedb.SexInterface;
import com.company.repository.onedb.TypeEducationInterface;
import com.company.repository.twodb.DfakInterface;
import com.company.repository.twodb.DstudentInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TypeEducationalService {
    private final TypeEducationInterface typeEducationInterface;

    public TypeEducation add(TypeEducation typeEducation) {
        return typeEducationInterface.save(typeEducation);
    }
}
