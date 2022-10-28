package com.iot.sec_yr.iot_jdbc_templete.controller.impl;

import com.iot.sec_yr.iot_jdbc_templete.controller.TripControler;
import com.iot.sec_yr.iot_jdbc_templete.domain.Trip;
import com.iot.sec_yr.iot_jdbc_templete.service.TripService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripControlerImpl implements TripControler {
    private final TripService tripService;

    public TripControlerImpl(TripService tripService) {
        this.tripService = tripService;
    }

    @Override
    public List<Trip> findAll() {
        return tripService.findAll();
    }

    @Override
    public Optional<Trip> findById(Integer id) {
        return tripService.findById(id);
    }

    @Override
    public int create(Trip trip) {
        return tripService.create(trip);
    }

    @Override
    public int update(Integer id, Trip trip) {
        return tripService.update(id, trip);
    }

    @Override
    public int delete(Integer id) {
        return tripService.delete(id);
    }
}
