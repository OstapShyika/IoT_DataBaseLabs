package com.iot.sec_yr.iot_jdbc_templete.service.impl;

import com.iot.sec_yr.iot_jdbc_templete.dao.OwnerDao;
import com.iot.sec_yr.iot_jdbc_templete.domain.Owner;
import org.springframework.stereotype.Service;
import com.iot.sec_yr.iot_jdbc_templete.service.OwnerService;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService {
    private final OwnerDao ownerDao;

    public OwnerServiceImpl(OwnerDao ownerDao) {
        this.ownerDao = ownerDao;
    }

    @Override
    public List<Owner> findAll() {
        return ownerDao.findAll();
    }

    @Override
    public Optional<Owner> findById(Integer id) {
        return ownerDao.findById(id);
    }

    @Override
    public int create(Owner owner) {
        return ownerDao.create(owner);
    }

    @Override
    public int update(Integer id, Owner owner) {
        return ownerDao.update(id, owner);
    }

    @Override
    public int delete(Integer id) {
        return ownerDao.delete(id);
    }
}
