package com.company.repository.onedb;

import com.company.electronicjournalDTO.DepartmentsDTO;
import com.company.postgre.Department;
import com.company.service.common.RSQLSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DepartmentInterface extends JpaRepository<Department, Long>, JpaSpecificationExecutor<Department>,
        RSQLSearch<Department, DepartmentsDTO> {
    Department findByShortName(String short_name);
}
