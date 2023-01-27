package com.company.repository.onedb;

import com.company.electronicjournalDTO.AcademicTitlesDTO;
import com.company.postgre.AcademicTitle;
import com.company.service.common.RSQLSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicTitleInterface extends JpaRepository<AcademicTitle, Long>, JpaSpecificationExecutor<AcademicTitle>,
        RSQLSearch<AcademicTitle, AcademicTitlesDTO> {
    AcademicTitle findByUchZvan(String name);
}
