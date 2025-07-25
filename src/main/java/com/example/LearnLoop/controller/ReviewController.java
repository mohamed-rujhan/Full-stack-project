package com.example.LearnLoop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.LearnLoop.model.Review;
import com.example.LearnLoop.service.ReviewService;


@RestController
@RequestMapping({"/api/reviews"})
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    public ReviewController(){}

    @PostMapping
    public ResponseEntity <Review> createReview(@RequestBody Review review){
        Review createdReview =this.reviewService.createReview(review);
        return ResponseEntity.ok(createdReview);
    }

    @GetMapping({"/{reviewId}"})
    public ResponseEntity<Review> getReviewById(@PathVariable String reviewId) 
    {
    Review review = this.reviewService.getReviewById(reviewId);
    return review != null ? ResponseEntity.ok(review) :
    ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() //get all reviews
    {
    List<Review> review = this.reviewService.getAllReviews();
    return ResponseEntity.ok(review);
    }

    @PutMapping({"/{reviewId}"})
    public ResponseEntity<Review> updateReview(@PathVariable String reviewId,@RequestBody Review review) 
    {
    Review updatedReview = this.reviewService.updateReview(reviewId, review);
    return updatedReview != null ? ResponseEntity.ok(updatedReview) :
    ResponseEntity.notFound().build();
    }

    @DeleteMapping({"/{reviewId}"})
    public ResponseEntity<Void> deleteReview(@PathVariable String reviewId) 
    {
    this.reviewService.deleteReview(reviewId);
    return ResponseEntity.noContent().build();
    }

}
