package com.iot.sec_yr.iot_jdbc_templete.service;

import com.iot.sec_yr.iot_jdbc_templete.domain.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService extends GeneralService<Review, Integer> {
    Optional<List<Review>> getReviewsByRating(Integer rating);
}
