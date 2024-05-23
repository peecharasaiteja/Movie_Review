package com.sai_dev.moviereview.service;

import com.sai_dev.moviereview.models.Review;
import com.sai_dev.moviereview.models.movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class reviewService {
    @Autowired
    private reviewRepository reviewrepository;
    @Autowired
    private MongoTemplate mongoTemplate;
public Review createReview(String reviewBody,String imdbId){
    Review review = reviewrepository.insert(new Review(reviewBody));

    mongoTemplate.update(movie.class)
            .matching(Criteria.where("imdbId").is(imdbId))
            .apply(new Update().push("reviewIds").value(review))
            .first();
    return review;
}


}

