package com.reviews.reviews.repository;

import com.reviews.reviews.bootsrap.DataHolder;
import com.reviews.reviews.model.Review;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InMemoryReviewRepository {
    public List<Review> findAll() {
        return DataHolder.reviews;
    }

    public List<Review> sortByRating(String orderByRating, List<Review> list) {
        if (orderByRating.equals("highest"))
            return list.stream().sorted(Comparator.comparing(Review::getRating).reversed()).collect(Collectors.toList());
        else
            return list.stream().sorted(Comparator.comparing(Review::getRating)).collect(Collectors.toList());
    }

    public List<Review> setMinRating(Integer minimumRating) {
        return DataHolder.reviews.stream().filter(i -> i.getRating() >= minimumRating).collect(Collectors.toList());
    }

    public List<Review> sortByDate(String orderByDate, List<Review> list) {
        if (orderByDate.equals("newest"))
            return list.stream().sorted(Comparator.comparing(Review::getReviewCreatedOnDate).reversed()).collect(Collectors.toList());
        else
            return list.stream().sorted(Comparator.comparing(Review::getReviewCreatedOnDate)).collect(Collectors.toList());
    }

    public List<Review> sortByText(String prioritizeByText, List<Review> list) {
        if (prioritizeByText.equals("yes")) {
            Comparator<Review> comparator = new Comparator<Review>() {
                @Override
                public int compare(Review s1, Review s2) {
                    if (s1.getReviewText().isEmpty() && !s2.getReviewText().isEmpty()) {
                        return 1;
                    }
                    else if (s2.getReviewText().isEmpty() && !s1.getReviewText().isEmpty()) {
                        return -1;
                    }
                    return 0;
                }
            };
            return list.stream().sorted(comparator).collect(Collectors.toList());
        }
        return list;
    }
}
