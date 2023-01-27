package com.company.service;

import com.company.mapper.Mapper;
import com.company.mysql.Dekzam;
import com.company.postgre.AttestationType;
import com.company.postgre.ForeignLanguage;
import com.company.repository.onedb.AttestationTypeInterface;
import com.company.repository.twodb.DekzamInterface;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AttestationTypeService {
    AttestationTypeInterface attestationTypeInterface;
    DekzamInterface dekzamInterface;
    Mapper<AttestationType, Dekzam> mapper;

    public List<AttestationType> addAll() {
        return attestationTypeInterface.saveAllAndFlush(mapper.toPostgres(dekzamInterface.findAll(), AttestationType.class));
    }
}
