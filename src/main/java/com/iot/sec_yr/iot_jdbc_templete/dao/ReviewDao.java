package com.iot.sec_yr.iot_jdbc_templete.dao;

import com.iot.sec_yr.iot_jdbc_templete.domain.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewDao extends GeneralDao<Review, Integer> {
    Optional<List<Review>> getReviewsByRating(Integer rating);
}
