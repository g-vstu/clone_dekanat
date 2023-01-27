package com.company.service;

import com.company.mapper.Mapper;
import com.company.mysql.DuchPlan;
import com.company.postgre.*;
import com.company.repository.onedb.*;
import com.company.repository.twodb.DuchPlanInterface;
import com.company.repository.twodb.DvedomInterface;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AcademicPlanService {
    AcademicPlanInterface academicPlanInterface;
    DuchPlanInterface duchPlanInterface;
    LoadInterface loadInterface;
    DvedomInterface dvedomInterface;
    GroupInterface groupInterface;
    StatementInterface statementInterface;
    DisciplineInterface disciplineInterface;
    AttestationTypeInterface attestationTypeInterface;
    Mapper<AcademicPlan, DuchPlan> mapper;

    public List<AcademicPlan> addAll() {
        AtomicLong it = new AtomicLong();
        List<AcademicPlan> academicPlans = mapper.toPostgres(duchPlanInterface.findAll(), AcademicPlan.class);
        Set<AcademicPlan> academicPlanSet = new HashSet<>();
        academicPlans.forEach(academicPlan -> {
            AcademicPlan academicPlan1 = academicPlanInterface.findByGroupNameAndSemesterNumber(academicPlan.getGr(), academicPlan.getSemesterNumber());
            if (academicPlan1 == null) {
                academicPlan.setGroup(groupInterface.findByName(academicPlan.getGr()));
                academicPlan1 = academicPlanInterface.saveAndFlush(academicPlan);
            }
            AttestationType attestationType = attestationTypeInterface.findByIdFromSource(academicPlan.getNekz());
            Discipline discipline = disciplineInterface.findByIdFromSource(academicPlan.getNdis());
            Load load = loadInterface.findByAttestationType_IdFromSourceAndDiscipline_IdFromSourceAndHoursNumberAndCreditUnits(
                    attestationType == null ? null : attestationType.getIdFromSource(), discipline == null ? null : discipline.getIdFromSource(),
                    academicPlan.getClock(), academicPlan.getCreditUnits());
            if (load == null) {
                load = new Load();
                load.setAttestationType(attestationType);
                load.setDiscipline(discipline);
                load.setHoursNumber(academicPlan.getClock());
                load.setCreditUnits(academicPlan.getCreditUnits());
                load = loadInterface.saveAndFlush(load);
            }
            Set<Load> loads = academicPlan1.getLoads() == null || academicPlan1.getLoads().isEmpty() ? new HashSet<>() : academicPlan1.getLoads();
            loads.add(load);
            academicPlan1.setLoads(loads);

            academicPlan1.setIdFromSource(academicPlan.getIdFromSource());
            academicPlanInterface.saveAndFlush(academicPlan1);
            System.out.println(it.incrementAndGet());
        });
        return null;
    }
}
