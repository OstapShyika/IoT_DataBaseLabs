package com.iot.sec_yr.iot_jdbc_templete.dao.impl;

import com.iot.sec_yr.iot_jdbc_templete.dao.UserDao;
import com.iot.sec_yr.iot_jdbc_templete.domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class UserDaoImpl implements UserDao {
    private static final String FIND_ALL = "SELECT * FROM user;";
    private static final String FIND_BY_ID = "SELECT * FROM user WHERE id=?;";
    private static final String CREATE = "INSERT user(name, email) VALUES (?, ?);";
    private static final String UPDATE = "UPDATE user SET name=?, email=? WHERE id=?;";
    private static final String DELETE = "DELETE FROM user WHERE id=?;";

    private final JdbcTemplate jdbcTemplate;

    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(User.class));
    }

    @Override
    public Optional<User> findById(Integer id) {
        Optional<User> users;
        try {
            users = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(User.class), id));
        } catch (Exception e) {
            users = Optional.empty();
        }
        return users;
    }

    @Override
    public int create(User user) {
        return jdbcTemplate.update(CREATE, user.getName(), user.getEmail());
    }

    @Override
    public int update(Integer id, User user) {
        return jdbcTemplate.update(UPDATE, user.getName(), user.getEmail(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
