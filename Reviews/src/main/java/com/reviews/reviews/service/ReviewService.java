package com.reviews.reviews.service;

import com.reviews.reviews.model.Review;

import java.util.List;

public interface ReviewService {
    List<Review> findAll();
    List<Review> setMinRating(String orderByRating, Integer minimumRating, String orderByDate, String prioritizeByText);
    List<Review> sortByRating(String orderByRating, List<Review> list);
    List<Review> sortByDate(String orderByDate, List<Review> list);
    List<Review> sortByText(String prioritizeByText, List<Review> list);
}
