package com.sai_dev.moviereview.service;

import com.sai_dev.moviereview.models.movie;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class movieService {
    @Autowired
    private movieRepository movierepository;
    public List<movie> allMovies(){
        return movierepository.findAll();

    }

    public Optional<movie> getMoviebyId(String imdbId) {
        return movierepository.findMovieByImdbId(imdbId);
    }
}
