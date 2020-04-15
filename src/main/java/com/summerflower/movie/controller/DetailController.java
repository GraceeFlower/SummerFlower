package com.summerflower.movie.controller;

import com.summerflower.movie.entities.Detail;
import com.summerflower.movie.services.DetailService;
import org.springframework.web.bind.annotation.*;

@RestController
public class DetailController {

    private final DetailService detailService;

    public DetailController(DetailService detailService) {
        this.detailService = detailService;
    }

    @PostMapping("/post")
    public void saveInfo(@RequestBody Detail detailList) {
        detailService.saveDetails(detailList);
    }

    @GetMapping("/movies/detail")
    public Detail getMovieById(@RequestParam(name = "id") int id) {
        return detailService.getMovieById(id);
    }

    @GetMapping("/movies/searched_movie")
    public Detail getMovieByTitle(@RequestParam(name = "title") String title) {
        return detailService.getMovieByTitle(title);
    }

}
