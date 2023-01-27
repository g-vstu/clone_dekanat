package com.company.repository.onedb;

import com.company.electronicjournalDTO.DisciplinesDTO;
import com.company.postgre.Discipline;
import com.company.postgre.Speciality;
import com.company.service.common.RSQLSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialityInterface extends JpaRepository<Speciality, Long>, JpaSpecificationExecutor<Discipline>,
        RSQLSearch<Discipline, DisciplinesDTO> {
    Speciality findByShortNameAndNameAndSpecialtyCodeAndFacultyId(String short_name, String name, String specialty_code, Long facultyId);
}
