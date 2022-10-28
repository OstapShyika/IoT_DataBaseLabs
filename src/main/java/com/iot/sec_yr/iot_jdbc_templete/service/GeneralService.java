package com.iot.sec_yr.iot_jdbc_templete.service;

import java.util.List;
import java.util.Optional;

public interface GeneralService<T, ID> {
    List<T> findAll();

    Optional<T> findById(ID id);

    int create(T entity);

    int update(ID id, T entity);

    int delete(ID id);
}
