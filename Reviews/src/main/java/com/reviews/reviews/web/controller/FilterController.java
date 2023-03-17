//package com.reviews.reviews.web.controller;
//
//import com.reviews.reviews.model.Review;
//import com.reviews.reviews.service.ReviewService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/filter")
//public class FilterController {
//    private final ReviewService reviewService;
//
//    public FilterController(ReviewService reviewService) {
//        this.reviewService = reviewService;
//    }
//
//    @GetMapping()
//    public String getFilterPage() {
//        return "filter";
//    }
//
//    @PostMapping("/reviews")
//    public String filterReviews(
//            @RequestParam String orderByRating,
//            @RequestParam Integer minimumRating,
//            @RequestParam String orderByDate,
//            @RequestParam String prioritizeByText,
//            Model model) {
//        List<Review> reviewsSorted = this.reviewService.setMinRating(orderByRating, minimumRating, orderByDate, prioritizeByText);
//        model.addAttribute("reviewsSorted", reviewsSorted);
//        System.out.printf("%s %d %s %s\n",orderByRating, minimumRating, orderByDate, prioritizeByText);
//        return "redirect:/reviews";
//    }
//}
