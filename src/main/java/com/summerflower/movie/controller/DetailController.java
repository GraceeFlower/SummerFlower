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

//    @GetMapping("{id}")
//    public Detail getInfo(@PathVariable Integer id) {
//        return detailService.getInfo(id);
//    }

}
