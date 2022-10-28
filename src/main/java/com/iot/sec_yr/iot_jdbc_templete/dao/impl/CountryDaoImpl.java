package com.iot.sec_yr.iot_jdbc_templete.dao.impl;

import com.iot.sec_yr.iot_jdbc_templete.dao.CountryDao;
import com.iot.sec_yr.iot_jdbc_templete.domain.Country;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class CountryDaoImpl implements CountryDao {
    private static final String FIND_ALL = "SELECT * FROM country;";
    private static final String FIND_BY_ID = "SELECT * FROM country WHERE id=?;";
    private static final String CREATE = "INSERT INTO country(name, description) VALUES (?, ?);";
    private static final String UPDATE = "UPDATE country SET name=?, description=? WHERE id=?;";
    private static final String DELETE = "DELETE FROM country WHERE id=?;";

    private final JdbcTemplate jdbcTemplate;

    public CountryDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Country> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Country.class));
    }

    @Override
    public Optional<Country> findById(Integer id) {
        Optional<Country> countrys;
        try {
            countrys = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Country.class), id));
        } catch (Exception e) {
            countrys = Optional.empty();
        }
        return countrys;
    }

    @Override
    public int create(Country country) {
        return jdbcTemplate.update(CREATE, country.getName(), country.getDescription());
    }

    @Override
    public int update(Integer id, Country country) {
        return jdbcTemplate.update(UPDATE, country.getName(), country.getDescription(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
