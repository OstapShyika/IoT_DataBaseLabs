package com.iot.sec_yr.iot_jdbc_templete.controller.impl;

import com.iot.sec_yr.iot_jdbc_templete.controller.CountryControler;
import com.iot.sec_yr.iot_jdbc_templete.domain.Country;
import com.iot.sec_yr.iot_jdbc_templete.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryControlerImpl implements CountryControler {

    private final CountryService countryService;

    public CountryControlerImpl(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public List<Country> findAll() {
        return countryService.findAll();
    }

    @Override
    public Optional<Country> findById(Integer id) {
        return countryService.findById(id);
    }

    @Override
    public int create(Country country) {
        return countryService.create(country);
    }

    @Override
    public int update(Integer id, Country country) {
        return countryService.update(id, country);
    }

    @Override
    public int delete(Integer id) {
        return countryService.delete(id);
    }
}
