package com.iot.sec_yr.iot_jdbc_templete.controller.impl;

import com.iot.sec_yr.iot_jdbc_templete.controller.TransportControler;
import com.iot.sec_yr.iot_jdbc_templete.domain.Transport;
import com.iot.sec_yr.iot_jdbc_templete.service.TransportService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransportControlerImpl implements TransportControler {

    private final TransportService transportService;

    public TransportControlerImpl(TransportService transportService) {
        this.transportService = transportService;
    }

    @Override
    public List<Transport> findAll() {
        return transportService.findAll();
    }

    @Override
    public Optional<Transport> findById(Integer id) {
        return transportService.findById(id);
    }

    @Override
    public int create(Transport transport) {
        return transportService.create(transport);
    }

    @Override
    public int update(Integer id, Transport transport) {
        return transportService.update(id, transport);
    }

    @Override
    public int delete(Integer id) {
        return transportService.delete(id);
    }
}
