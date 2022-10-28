package com.iot.sec_yr.iot_jdbc_templete.dao.impl;

import com.iot.sec_yr.iot_jdbc_templete.dao.TransportDao;
import com.iot.sec_yr.iot_jdbc_templete.domain.Transport;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class TransportDaoImpl implements TransportDao {
    private static final String FIND_ALL = "SELECT * FROM transport;";
    private static final String FIND_BY_ID = "SELECT * FROM transport WHERE id=?;";
    private static final String CREATE = "INSERT transport(type, route, place_id) VALUES (?, ?, ?);";
    private static final String UPDATE = "UPDATE transport SET type=?, route=?, place_id=? WHERE id=?;";
    private static final String DELETE = "DELETE FROM transport WHERE id=?;";

    private final JdbcTemplate jdbcTemplate;

    public TransportDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Transport> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Transport.class));
    }

    @Override
    public Optional<Transport> findById(Integer id) {
        Optional<Transport> transports;
        try {
            transports = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Transport.class), id));
        } catch (Exception e) {
            transports = Optional.empty();
        }
        return transports;
    }

    @Override
    public int create(Transport transport) {
        return jdbcTemplate.update(CREATE, transport.getType(), transport.getRoute(), transport.getPlaceId());
    }

    @Override
    public int update(Integer id, Transport transport) {
        return jdbcTemplate.update(UPDATE, transport.getType(), transport.getRoute(), transport.getPlaceId(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
