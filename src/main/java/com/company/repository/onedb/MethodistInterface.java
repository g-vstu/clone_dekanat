package com.company.repository.onedb;

import com.company.postgre.Methodist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface MethodistInterface extends JpaRepository<Methodist, Long> {
    Set<Methodist> findByFio(String fio);
}
