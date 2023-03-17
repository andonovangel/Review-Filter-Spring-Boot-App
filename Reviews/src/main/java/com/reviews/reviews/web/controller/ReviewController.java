package com.reviews.reviews.web.controller;

import com.reviews.reviews.model.Review;
import com.reviews.reviews.service.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public String getReviewPage(Model model) {
        List<Review> reviews = this.reviewService.findAll();
        model.addAttribute("reviews", reviews);
        return "review";
    }

    @GetMapping("/filter")
    public String getFilterPage() {
        return "filter";
    }

    @RequestMapping(value = "/filter/reviews", method = RequestMethod.POST)
    public String filterReviews(
            @RequestParam String orderByRating,
            @RequestParam Integer minimumRating,
            @RequestParam String orderByDate,
            @RequestParam String prioritizeByText,
            Model model) {
        List<Review> reviewsSetByMinRating = this.reviewService.setMinRating(orderByRating, minimumRating, orderByDate, prioritizeByText);
        List<Review> reviewsSortedByDate = this.reviewService.sortByDate(orderByDate, reviewsSetByMinRating);
        List<Review> reviewsSortedByRating = this.reviewService.sortByRating(orderByRating, reviewsSortedByDate);
        List<Review> reviewsSortedByText = this.reviewService.sortByText(prioritizeByText, reviewsSortedByRating);
        model.addAttribute("reviewsSorted", reviewsSortedByText);
        return "review";
    }
}
