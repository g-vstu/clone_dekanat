package com.company.mapper;


import com.company.mysql.MySqlEntity;
import com.company.postgre.PostgreEntity;
import org.modelmapper.ModelMapper;

import java.util.List;

/**
 * Interface for convert Entities and DTOs in both ways
 *
 * @param <E> entity for convert
 * @param <D> dto for convert
 */
public interface Mapper<E extends PostgreEntity, D extends MySqlEntity> {

    ModelMapper mapper = new ModelMapper();


    D toMSql(E postgre, Class<D> type);


    E toPostgre(D mSql, Class<E> type);


    List<D> toMSqls(List<E> postgres, Class<D> type);


    List<E> toPostgres(List<D> mqls, Class<E> type);

}
