package com.iot.sec_yr.iot_jdbc_templete.controller.impl;

import com.iot.sec_yr.iot_jdbc_templete.controller.PlaceControler;
import com.iot.sec_yr.iot_jdbc_templete.domain.Place;
import com.iot.sec_yr.iot_jdbc_templete.service.PlaceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceControlerImpl implements PlaceControler {
    private final PlaceService placeService;

    public PlaceControlerImpl(PlaceService placeService) {
        this.placeService = placeService;
    }

    @Override
    public List<Place> findAll() {
        return placeService.findAll();
    }

    @Override
    public Optional<Place> findById(Integer id) {
        return placeService.findById(id);
    }

    @Override
    public int create(Place place) {
        return placeService.create(place);
    }

    @Override
    public int update(Integer id, Place place) {
        return placeService.update(id, place);
    }

    @Override
    public int delete(Integer id) {
        return placeService.delete(id);
    }
}
