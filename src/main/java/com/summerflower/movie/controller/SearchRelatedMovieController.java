package com.summerflower.movie.controller;

import com.summerflower.movie.entities.SearchRelatedMovie;
import com.summerflower.movie.services.SearchRelatedMovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchRelatedMovieController {

    private final SearchRelatedMovieService searchRelatedMovieService;

    public SearchRelatedMovieController(SearchRelatedMovieService searchRelatedMovieService){
        this.searchRelatedMovieService = searchRelatedMovieService;
    }

    @GetMapping("/searchRelatedMovie/keyword")
    public Iterable<SearchRelatedMovie> getSearchRelatedMovies(@RequestParam(name = "keyword") String keyword) {
        return searchRelatedMovieService.getSearchRelatedMovies(keyword);
    }
}
