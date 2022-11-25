package com.example.springbootbackend.service;

import com.example.springbootbackend.domain.Place;
import com.example.springbootbackend.domain.User;

import java.util.List;

public interface UserService extends GeneralService<User, Integer> {
    public User create(User user, Integer countryId);
    public List<Place> findPlacesById(Integer id);
}
