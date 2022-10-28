package com.iot.sec_yr.iot_jdbc_templete.controller;

import com.iot.sec_yr.iot_jdbc_templete.domain.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewControler extends GeneralControler<Review, Integer> {
    Optional<List<Review>> getReviewsByRating(Integer rating);
}
