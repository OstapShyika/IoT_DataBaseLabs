package com.iot.sec_yr.iot_jdbc_templete.service.impl;

import com.iot.sec_yr.iot_jdbc_templete.dao.UserDao;
import com.iot.sec_yr.iot_jdbc_templete.domain.User;
import org.springframework.stereotype.Service;
import com.iot.sec_yr.iot_jdbc_templete.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public int create(User user) {
        return userDao.create(user);
    }

    @Override
    public int update(Integer id, User user) {
        return userDao.update(id, user);
    }

    @Override
    public int delete(Integer id) {
        return userDao.delete(id);
    }
}
