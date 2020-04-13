package com.summerflower.movie.controller;

import com.summerflower.movie.entities.Movie;
import com.summerflower.movie.services.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public Iterable<Movie> getMovies() {
        return movieService.getMovies();
    }
}
