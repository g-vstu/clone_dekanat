package com.company.repository.onedb;

import com.company.postgre.Guardian;
import com.company.postgre.Sex;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuardianInterface extends JpaRepository<Guardian, Long> {
    Guardian findByFioAndSexPolAndPhoneAndWorkPlace(String fio, String sexPol, String phone, String workPlace);
}
