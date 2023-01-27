package com.company.mapper;

import com.company.mysql.MySqlEntity;
import com.company.postgre.PostgreEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommonMapperImpl<E extends PostgreEntity, D extends MySqlEntity>
        implements Mapper<E, D> {

    @Override
    public D toMSql(E postgre, Class<D> type) {
        return null;
    }

    @Override
    public E toPostgre(D mSql, Class<E> type) {
        return mapper.map(mSql, type);
    }

    @Override
    public List<D> toMSqls(List<E> postgres, Class<D> type) {
        return null;
    }

    @Override
    public List<E> toPostgres(List<D> mqls, Class<E> type) {
        return mqls.stream().map(d -> toPostgre(d, type)).collect(Collectors.toList());
    }
}
