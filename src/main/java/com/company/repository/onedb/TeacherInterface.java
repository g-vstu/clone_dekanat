package com.company.repository.onedb;

import com.company.electronicjournalDTO.StudentsDTO;
import com.company.electronicjournalDTO.TeachersDTO;
import com.company.mysql.Dmetodist;
import com.company.postgre.Student;
import com.company.postgre.Teacher;
import com.company.service.common.RSQLSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TeacherInterface extends JpaRepository<Teacher, Long>, JpaSpecificationExecutor<Teacher>,
        RSQLSearch<Teacher, TeachersDTO> {
    Teacher findByIdFromSource(Long idFromSource);
}
