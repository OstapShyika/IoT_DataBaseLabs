package com.iot.sec_yr.iot_jdbc_templete.service.impl;

import com.iot.sec_yr.iot_jdbc_templete.dao.TripDao;
import com.iot.sec_yr.iot_jdbc_templete.domain.Trip;
import org.springframework.stereotype.Service;
import com.iot.sec_yr.iot_jdbc_templete.service.TripService;

import java.util.List;
import java.util.Optional;

@Service
public class TripServiceImpl implements TripService {
    private final TripDao tripDao;

    public TripServiceImpl(TripDao tripDao) {
        this.tripDao = tripDao;
    }

    @Override
    public List<Trip> findAll() {
        return tripDao.findAll();
    }

    @Override
    public Optional<Trip> findById(Integer id) {
        return tripDao.findById(id);
    }

    @Override
    public int create(Trip trip) {
        return tripDao.create(trip);
    }

    @Override
    public int update(Integer id, Trip trip) {
        return tripDao.update(id, trip);
    }

    @Override
    public int delete(Integer id) {
        return tripDao.delete(id);
    }
}
