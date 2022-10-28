package com.iot.sec_yr.iot_jdbc_templete.dao.impl;

import com.iot.sec_yr.iot_jdbc_templete.dao.PlaceDao;
import com.iot.sec_yr.iot_jdbc_templete.domain.Place;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class PlaceDaoImpl implements PlaceDao {
    private static final String FIND_ALL = "SELECT * FROM place;";
    private static final String FIND_BY_ID = "SELECT * FROM place WHERE id=?;";
    private static final String CREATE = "INSERT place(name, country_id, pricing) VALUES (?, ?, ?);";
    private static final String UPDATE = "UPDATE place SET name=?, country_id=?, pricing=? WHERE id=?;";
    private static final String DELETE = "DELETE FROM place WHERE id=?;";

    private final JdbcTemplate jdbcTemplate;

    public PlaceDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Place> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Place.class));
    }

    @Override
    public Optional<Place> findById(Integer id) {
        Optional<Place> places;
        try {
            places = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Place.class), id));
        } catch (Exception e) {
            places = Optional.empty();
        }
        return places;
    }

    @Override
    public int create(Place place) {
        return jdbcTemplate.update(CREATE, place.getName(), place.getCountryId(), place.getPricing());
    }

    @Override
    public int update(Integer id, Place place) {
        return jdbcTemplate.update(UPDATE, place.getName(), place.getCountryId(), place.getPricing(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
