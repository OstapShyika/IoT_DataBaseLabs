package com.iot.sec_yr.iot_jdbc_templete.dao.impl;

import com.iot.sec_yr.iot_jdbc_templete.dao.TripDao;
import com.iot.sec_yr.iot_jdbc_templete.domain.Trip;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class TripDaoImpl implements TripDao {
    private static final String FIND_ALL = "SELECT * FROM trip;";
    private static final String FIND_BY_ID = "SELECT * FROM trip WHERE id=?;";
    private static final String CREATE = "INSERT trip(name, user_id) VALUES (?, ?);";
    private static final String UPDATE = "UPDATE trip SET name=?, user_id=? WHERE id=?;";
    private static final String DELETE = "DELETE FROM trip WHERE id=?;";

    private final JdbcTemplate jdbcTemplate;

    public TripDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Trip> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Trip.class));
    }

    @Override
    public Optional<Trip> findById(Integer id) {
        Optional<Trip> trips;
        try {
            trips = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Trip.class), id));
        } catch (Exception e) {
            trips = Optional.empty();
        }
        return trips;
    }

    @Override
    public int create(Trip trip) {
        return jdbcTemplate.update(CREATE, trip.getName(), trip.getUserId());
    }

    @Override
    public int update(Integer id, Trip trip) {
        return jdbcTemplate.update(UPDATE, trip.getName(), trip.getUserId(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
