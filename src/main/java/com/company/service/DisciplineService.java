package com.company.service;

import com.company.mapper.Mapper;
import com.company.mysql.Ddiscip;
import com.company.mysql.Dkaf;
import com.company.postgre.*;
import com.company.repository.onedb.DepartmentInterface;
import com.company.repository.onedb.DisciplineInterface;
import com.company.repository.twodb.DdiscipInterface;
import com.company.repository.twodb.DkafInterface;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DisciplineService {
    DisciplineInterface disciplineInterface;
    DepartmentInterface departmentInterface;
    DdiscipInterface ddiscipInterface;
    DkafInterface dkafInterface;
    Mapper<Discipline, Ddiscip> mapper;

    public List<Discipline> addAll() {
        List<Discipline> disciplines = mapper.toPostgres(ddiscipInterface.findAll(), Discipline.class);
        disciplines.forEach(discipline -> {
            //Optional<Dkaf> dkafOptional = dkafInterface.findById(discipline.getDkafId());
            Dkaf dkaf = dkafInterface.findById(discipline.getDkafId() == null ? 0 : discipline.getDkafId()).orElse(null);
            if (dkaf != null) {
                String shortName = dkaf.getShortName();
                if (shortName.equals("МАЛП")) {
                    shortName = "ИСАП";
                } else if (shortName.equals("КиТИК")) {
                    shortName = "КиТОиО";
                }
                Department department = departmentInterface.findByShortName(shortName);
                discipline.setDepartment(department);
            }
        });
        return disciplineInterface.saveAllAndFlush(disciplines);
    }
}
