package com.summerflower.movie.controller;

import com.summerflower.movie.entities.Video;
import com.summerflower.movie.services.VideoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VideoController {

    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping("/movies/video")
    public Iterable<Video> getVideosByMovieId(@RequestParam(name = "id") int id) {
        return videoService.getVideosByMovieId(id);
    }
}
