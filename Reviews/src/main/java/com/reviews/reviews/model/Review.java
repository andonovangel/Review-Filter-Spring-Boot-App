package com.reviews.reviews.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

@Data
public class Review {
    public int id;
    public String reviewId;
    public String reviewFullText;
    public String reviewText;
    public int numLikes;
    public int numComments;
    public int numShares;
    public int rating;
    public String reviewCreatedOn;
    public Date reviewCreatedOnDate;
    public int reviewCreatedOnTime;
    public String reviewerId;
    public String reviewerUrl;
    public String reviewerName;
    public String reviewerEmail;
    public String sourceType;
    public boolean isVerified;
    public String source;
    public String sourceName;
    public String sourceId;
    public ArrayList<String> tags;
    public String href;
    public String logoHref;
    public ArrayList<String> photos;
}
