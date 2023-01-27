package com.company.repository.onedb;

import com.company.electronicjournalDTO.DepartmentsDTO;
import com.company.electronicjournalDTO.DisciplinesDTO;
import com.company.postgre.Department;
import com.company.postgre.Discipline;
import com.company.service.common.RSQLSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DisciplineInterface extends JpaRepository<Discipline, Long>, JpaSpecificationExecutor<Discipline>,
        RSQLSearch<Discipline, DisciplinesDTO> {
    Discipline findByIdFromSource(Long idFromSource);
}
