package com.iot.sec_yr.iot_jdbc_templete.service.impl;

import com.iot.sec_yr.iot_jdbc_templete.dao.PlaceDao;
import com.iot.sec_yr.iot_jdbc_templete.domain.Place;
import org.springframework.stereotype.Service;
import com.iot.sec_yr.iot_jdbc_templete.service.PlaceService;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceServiceImpl implements PlaceService {
    private final PlaceDao placeDao;

    public PlaceServiceImpl(PlaceDao placeDao) {
        this.placeDao = placeDao;
    }

    @Override
    public List<Place> findAll() {
        return placeDao.findAll();
    }

    @Override
    public Optional<Place> findById(Integer id) {
        return placeDao.findById(id);
    }

    @Override
    public int create(Place place) {
        return placeDao.create(place);
    }

    @Override
    public int update(Integer id, Place place) {
        return placeDao.update(id, place);
    }

    @Override
    public int delete(Integer id) {
        return placeDao.delete(id);
    }

}
