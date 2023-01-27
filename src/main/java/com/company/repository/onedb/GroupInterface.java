package com.company.repository.onedb;

import com.company.electronicjournalDTO.FacultiesDTO;
import com.company.electronicjournalDTO.GroupsDTO;
import com.company.postgre.Faculty;
import com.company.postgre.Group;
import com.company.service.common.RSQLSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GroupInterface extends JpaRepository<Group, Long>, JpaSpecificationExecutor<Group>,
        RSQLSearch<Group, GroupsDTO> {
    Group findByName(String name);
}
