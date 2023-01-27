package com.company.repository.twodb;

import com.company.mysql.Dotklon;
import com.company.mysql.Dspec;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DotklonInterface extends JpaRepository<Dotklon, Long> {
    List<Dotklon> findByDeloAndFamLike(String delo, String surname);

    List<Dotklon> findByDelo(String delo);
}
