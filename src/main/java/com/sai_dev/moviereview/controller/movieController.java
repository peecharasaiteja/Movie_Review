package com.sai_dev.moviereview.controller;

import com.sai_dev.moviereview.models.movie;
import com.sai_dev.moviereview.service.movieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class movieController {
    @Autowired
    private movieService movieservice;
    @GetMapping
    public ResponseEntity<List<movie>> getAllMovies(){
        return new ResponseEntity<List<movie>>(movieservice.allMovies(),HttpStatus.OK);

    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<movie>> getMoviesById(@PathVariable String imdbId){
        return new ResponseEntity<Optional<movie>>(movieservice.getMoviebyId(imdbId),HttpStatus.OK);
    }
}
