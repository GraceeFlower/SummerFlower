package com.summerflower.movie.services;

import com.summerflower.movie.entities.SearchRelatedMovie;
import com.summerflower.movie.repositories.SearchRelatedMovieRepository;
import org.springframework.stereotype.Service;

@Service
public class SearchRelatedMovieService {
    private final SearchRelatedMovieRepository searchRelatedMovieRepository;

    public SearchRelatedMovieService(SearchRelatedMovieRepository searchRelatedMovieRepository){
        this.searchRelatedMovieRepository = searchRelatedMovieRepository;
    }

    public Iterable<SearchRelatedMovie> getSearchRelatedMovies(String keyword) {
        return searchRelatedMovieRepository.findMoviesByKeyword("%" + keyword + "%");
    }
}
