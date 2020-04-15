package com.summerflower.movie.services;

import com.summerflower.movie.entities.Movie;
import com.summerflower.movie.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

    public List<String> getMenu() {
        return Arrays.stream(StreamSupport.stream(movieRepository.findAll().spliterator(), false)
            .map(Movie::getGenres).collect(Collectors.joining(","))
            .split(",")).distinct().collect(Collectors.toList());
    }

    public Iterable<Movie> getPointedTypeMovies(String type) {
        return movieRepository.findMoviesByType("%" + type + "%");
    }

    public Iterable<Movie> getSimilarTypeMovies(String type, int id) {
        Set<Movie> movieSet = new HashSet<>();
        for(String i : type.split(",")) {
            movieRepository.findSimilarMoviesByType("%" + i + "%", id).forEach(movieSet::add);
        }
        return movieSet;
    }
}
