package com.summerflower.movie.controller;

import com.summerflower.movie.entities.Detail;
import com.summerflower.movie.services.DetailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class DetailController {

    private final DetailService detailService;

    public DetailController(DetailService detailService) {
        this.detailService = detailService;
    }

    @PostMapping("/post")
    public void saveInfo(@RequestBody List<Detail> detailList) {
        detailService.saveDetails(detailList);
    }

}
