package com.iot.sec_yr.iot_jdbc_templete.dao.impl;

import com.iot.sec_yr.iot_jdbc_templete.dao.OwnerDao;
import com.iot.sec_yr.iot_jdbc_templete.domain.Owner;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class OwnerDaoImpl implements OwnerDao {
    private static final String FIND_ALL = "SELECT * FROM owner;";
    private static final String FIND_BY_ID = "SELECT * FROM owner WHERE id=?;";
    private static final String CREATE = "INSERT INTO owner(name, surname) VALUES (?, ?);";
    private static final String UPDATE = "UPDATE owner SET name=?, surname=? WHERE id=?;";
    private static final String DELETE = "DELETE FROM owner WHERE id=?;";

    private final JdbcTemplate jdbcTemplate;

    public OwnerDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Owner> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Owner.class));
    }

    @Override
    public Optional<Owner> findById(Integer id) {
        Optional<Owner> owners;
        try {
            owners = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Owner.class), id));
        } catch (Exception e) {
            owners = Optional.empty();
        }
        return owners;
    }

    @Override
    public int create(Owner owner) {
        return jdbcTemplate.update(CREATE, owner.getName(), owner.getSurname());
    }

    @Override
    public int update(Integer id, Owner owner) {
        return jdbcTemplate.update(UPDATE, owner.getName(), owner.getSurname(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
