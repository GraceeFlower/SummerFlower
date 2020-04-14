package com.summerflower.movie.services;

import com.summerflower.movie.entities.Movie;
import com.summerflower.movie.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;


    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Iterable<Movie> getDisplayMoviesInRange(int num) {
        System.out.println(movieRepository.findMovieInRange(num));
        return movieRepository.findMovieInRange(num);
    }

    public List<Integer> getId() {
        List<Integer> idList = new ArrayList<>();
        movieRepository.findAll().forEach(item -> idList.add(item.getId()));
        return idList;
    }
}
