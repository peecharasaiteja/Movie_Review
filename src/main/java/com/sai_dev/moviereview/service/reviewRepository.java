package com.sai_dev.moviereview.service;

import com.sai_dev.moviereview.models.Review;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface reviewRepository extends MongoRepository<Review, ObjectId>{
}
