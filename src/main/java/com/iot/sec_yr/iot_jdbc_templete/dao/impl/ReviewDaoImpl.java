package com.iot.sec_yr.iot_jdbc_templete.dao.impl;

import com.iot.sec_yr.iot_jdbc_templete.dao.ReviewDao;
import com.iot.sec_yr.iot_jdbc_templete.domain.Review;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class ReviewDaoImpl implements ReviewDao {

    private static final String FIND_ALL = "SELECT * FROM review;";
    private static final String FIND_BY_ID = "SELECT * FROM review WHERE id=?;";
    private static final String CREATE = "INSERT INTO review(rating, description, user_id, place_id) VALUES (?, ?, ?, ?);";
    private static final String UPDATE = "UPDATE review SET rating=?, description=?, user_id=?, place_id=? WHERE id=?;";
    private static final String DELETE = "DELETE FROM review WHERE id=?;";
    private static final String GET_BY_RATING = "SELECT FROM review WHERE rating=?;";

    private final JdbcTemplate jdbcTemplate;

    public ReviewDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Review> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Review.class));
    }

    @Override
    public Optional<Review> findById(Integer id) {
        Optional<Review> reviews;
        try {
            reviews = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Review.class), id));
        } catch (Exception e) {
            reviews = Optional.empty();
        }
        return reviews;
    }

    @Override
    public int create(Review review) {
        return jdbcTemplate.update(CREATE, review.getRating(), review.getDescription(), review.getUserId(),
                review.getPlaceId());
    }

    @Override
    public int update(Integer id, Review review) {
        return jdbcTemplate.update(UPDATE, review.getRating(), review.getDescription(), review.getUserId(),
                review.getPlaceId(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public Optional<List<Review>> getReviewsByRating(Integer rating) {
        Optional<List<Review>> reviews;
        try {
            reviews = Optional.of(jdbcTemplate.query(GET_BY_RATING,
                    BeanPropertyRowMapper.newInstance(Review.class), rating));
        } catch (Exception e) {
            reviews = Optional.empty();
        }
        return reviews;
    }
}
