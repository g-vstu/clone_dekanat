package com.company.repository.onedb;

import com.company.electronicjournalDTO.ForeignLanguagesDTO;
import com.company.electronicjournalDTO.GroupsDTO;
import com.company.postgre.ForeignLanguage;
import com.company.postgre.Group;
import com.company.service.common.RSQLSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LanguageInterface extends JpaRepository<ForeignLanguage, Long>, JpaSpecificationExecutor<ForeignLanguage>,
        RSQLSearch<ForeignLanguage, ForeignLanguagesDTO> {
    ForeignLanguage findByName(String name);
}
