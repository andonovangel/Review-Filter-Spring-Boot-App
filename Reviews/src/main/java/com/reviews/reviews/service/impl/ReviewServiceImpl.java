package com.reviews.reviews.service.impl;

import com.reviews.reviews.model.Review;
import com.reviews.reviews.repository.InMemoryReviewRepository;
import com.reviews.reviews.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final InMemoryReviewRepository reviewRepository;

    public ReviewServiceImpl(InMemoryReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public List<Review> setMinRating(String orderByRating, Integer minimumRating, String orderByDate, String prioritizeByText) {
        return reviewRepository.setMinRating(minimumRating);
    }

    @Override
    public List<Review> sortByRating(String orderByRating, List<Review> list) {
        return reviewRepository.sortByRating(orderByRating, list);
    }

    @Override
    public List<Review> sortByDate(String orderByDate, List<Review> list) {
        return reviewRepository.sortByDate(orderByDate, list);
    }

    @Override
    public List<Review> sortByText(String prioritizeByText, List<Review> list) {
        return reviewRepository.sortByText(prioritizeByText, list);
    }


}
