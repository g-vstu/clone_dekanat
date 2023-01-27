package com.company.service;

import com.company.mapper.Mapper;
import com.company.mysql.Dinostr;
import com.company.postgre.Citizenship;
import com.company.postgre.ForeignLanguage;
import com.company.repository.onedb.LanguageInterface;
import com.company.repository.twodb.DInostrInterface;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class LanguageService {
    LanguageInterface languageInterface;
    DInostrInterface dInostrInterface;
    Mapper<ForeignLanguage, Dinostr> mapper;

    public List<ForeignLanguage> addAll() {
        return languageInterface.saveAllAndFlush(mapper.toPostgres(dInostrInterface.findAll(), ForeignLanguage.class));
    }
}
