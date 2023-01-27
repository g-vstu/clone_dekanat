package com.company.repository.onedb;

import com.company.electronicjournalDTO.AcademicTitlesDTO;
import com.company.electronicjournalDTO.FacultiesDTO;
import com.company.postgre.AcademicTitle;
import com.company.postgre.Faculty;
import com.company.service.common.RSQLSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FacultyInterface extends JpaRepository<Faculty, Long>, JpaSpecificationExecutor<Faculty>,
        RSQLSearch<Faculty, FacultiesDTO> {
    Faculty findByName(String name);
}
