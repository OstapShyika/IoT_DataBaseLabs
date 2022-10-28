package com.iot.sec_yr.iot_jdbc_templete.service.impl;

import com.iot.sec_yr.iot_jdbc_templete.dao.ReviewDao;
import com.iot.sec_yr.iot_jdbc_templete.domain.Review;
import org.springframework.stereotype.Service;
import com.iot.sec_yr.iot_jdbc_templete.service.ReviewService;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewDao reviewDao;

    public ReviewServiceImpl(ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }

    @Override
    public List<Review> findAll() {
        return reviewDao.findAll();
    }

    @Override
    public Optional<Review> findById(Integer id) {
        return reviewDao.findById(id);
    }

    @Override
    public int create(Review review) {
        return reviewDao.create(review);
    }

    @Override
    public int update(Integer id, Review review) {
        return reviewDao.update(id, review);
    }

    @Override
    public int delete(Integer id) {
        return reviewDao.delete(id);
    }

    @Override
    public Optional<List<Review>> getReviewsByRating(Integer rating) {
        return reviewDao.getReviewsByRating(rating);
    }
}
