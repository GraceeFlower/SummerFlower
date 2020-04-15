package com.summerflower.movie.services;

import com.summerflower.movie.entities.Video;
import com.summerflower.movie.repositories.VideoRepository;
import org.springframework.stereotype.Service;

@Service
public class VideoService {

    private final VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public Iterable<Video> getVideosByMovieId(int id) {
        return videoRepository.findVideosById(id);
    }
}
