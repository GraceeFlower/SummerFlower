package com.summerflower.movie.controller;

import com.summerflower.movie.entities.Detail;
import com.summerflower.movie.entities.Movie;
import com.summerflower.movie.services.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public Iterable<Movie> getDisplayMoviesInRange(@RequestParam(name = "num") int num) {
        return movieService.getDisplayMoviesInRange(num);
    }

    @GetMapping("/movies/idList")
    public List<Integer> getIdList() {
        return movieService.getId();
    }

    @GetMapping("/movies/menu")
    public List<String> getMenu() {
        return movieService.getMenu();
    }

    @GetMapping("/movies/type")
    public Iterable<Movie> getPointedTypeMovies(@RequestParam(name = "type") String type) {
        return movieService.getPointedTypeMovies(type);
    }

}
