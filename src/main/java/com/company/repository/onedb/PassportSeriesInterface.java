package com.company.repository.onedb;

import com.company.mysql.Dgraj;
import com.company.postgre.PassportSeries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportSeriesInterface extends JpaRepository<PassportSeries, Long> {
    PassportSeries findByPassportSerija(String passport_serija);
}
