package com.iot.sec_yr.iot_jdbc_templete.service.impl;

import com.iot.sec_yr.iot_jdbc_templete.dao.TransportDao;
import com.iot.sec_yr.iot_jdbc_templete.domain.Transport;
import org.springframework.stereotype.Service;
import com.iot.sec_yr.iot_jdbc_templete.service.TransportService;

import java.util.List;
import java.util.Optional;

@Service
public class TransportServiceImpl implements TransportService {
    private final TransportDao transportDao;

    public TransportServiceImpl(TransportDao transportDao) {
        this.transportDao = transportDao;
    }

    @Override
    public List<Transport> findAll() {
        return transportDao.findAll();
    }

    @Override
    public Optional<Transport> findById(Integer id) {
        return transportDao.findById(id);
    }

    @Override
    public int create(Transport transport) {
        return transportDao.create(transport);
    }

    @Override
    public int update(Integer id, Transport transport) {
        return transportDao.update(id, transport);
    }

    @Override
    public int delete(Integer id) {
        return transportDao.delete(id);
    }
}
