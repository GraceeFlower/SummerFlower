package com.summerflower.movie.services;

import com.summerflower.movie.entities.Movie;
import com.summerflower.movie.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;


    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Iterable<Movie> getMovies() {
        return movieRepository.findAll();
    }
}
