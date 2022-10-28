package com.iot.sec_yr.iot_jdbc_templete.controller.impl;

import com.iot.sec_yr.iot_jdbc_templete.controller.ReviewControler;
import com.iot.sec_yr.iot_jdbc_templete.domain.Review;
import org.springframework.stereotype.Service;
import com.iot.sec_yr.iot_jdbc_templete.service.ReviewService;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewControlerImpl implements ReviewControler {

    private final ReviewService reviewService;

    public ReviewControlerImpl(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @Override
    public List<Review> findAll() {
        return reviewService.findAll();
    }

    @Override
    public Optional<Review> findById(Integer id) {
        return reviewService.findById(id);
    }

    @Override
    public int create(Review review) {
        return reviewService.create(review);
    }

    @Override
    public int update(Integer id, Review review) {
        return reviewService.update(id, review);
    }

    @Override
    public int delete(Integer id) {
        return reviewService.delete(id);
    }

    @Override
    public Optional<List<Review>> getReviewsByRating(Integer rating) {
        return reviewService.getReviewsByRating(rating);
    }
}
