package com.iot.sec_yr.iot_jdbc_templete.controller.impl;

import com.iot.sec_yr.iot_jdbc_templete.controller.OwnerControler;
import com.iot.sec_yr.iot_jdbc_templete.domain.Owner;
import com.iot.sec_yr.iot_jdbc_templete.service.OwnerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerControlerImpl implements OwnerControler {

    private final OwnerService ownerService;

    public OwnerControlerImpl(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @Override
    public List<Owner> findAll() {
        return ownerService.findAll();
    }

    @Override
    public Optional<Owner> findById(Integer id) {
        return ownerService.findById(id);
    }

    @Override
    public int create(Owner owner) {
        return ownerService.create(owner);
    }

    @Override
    public int update(Integer id, Owner owner) {
        return ownerService.update(id, owner);
    }

    @Override
    public int delete(Integer id) {
        return ownerService.delete(id);
    }
}
