package com.company.repository.onedb;

import com.company.electronicjournalDTO.ForeignLanguagesDTO;
import com.company.electronicjournalDTO.StudentsDTO;
import com.company.postgre.ForeignLanguage;
import com.company.postgre.Speciality;
import com.company.postgre.Student;
import com.company.service.common.RSQLSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface StudentInterface extends JpaRepository<Student, Long>, JpaSpecificationExecutor<Student>,
        RSQLSearch<Student, StudentsDTO> {
    Student findByNumberOfStudentbookAndGroupName(String numberOfStudentbook, String groupName);

    Student findByNumberOfStudentbook(String numberOfStudentbook);

    Student findByNumberOfStudentbookAndSurnameLike(String numberOfStudentbook, String surname);

    Student findByGroupNameAndSurnameLike(String groupName, String surname);

    Student findBySurnameLikeAndNameLikeAndPatronymicLike(String surname, String name, String patronymic);

    Student findBySurnameLikeAndNameLikeAndPatronymicLikeAndGroupNameLike(String surname, String name, String patronymic, String groupName);
}
