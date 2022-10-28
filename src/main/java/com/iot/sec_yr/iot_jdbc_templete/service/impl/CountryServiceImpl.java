package com.iot.sec_yr.iot_jdbc_templete.service.impl;

import com.iot.sec_yr.iot_jdbc_templete.dao.CountryDao;
import com.iot.sec_yr.iot_jdbc_templete.domain.Country;
import com.iot.sec_yr.iot_jdbc_templete.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryDao countryDao;

    public CountryServiceImpl(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    @Override
    public List<Country> findAll() {
        return countryDao.findAll();
    }

    @Override
    public Optional<Country> findById(Integer id) {
        return countryDao.findById(id);
    }

    @Override
    public int create(Country country) {
        return countryDao.create(country);
    }

    @Override
    public int update(Integer id, Country country) {
        return countryDao.update(id, country);
    }

    @Override
    public int delete(Integer id) {
        return countryDao.delete(id);
    }
}
