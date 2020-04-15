package com.summerflower.movie.repositories;

import com.summerflower.movie.entities.SearchRelatedMovie;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SearchRelatedMovieRepository extends CrudRepository<SearchRelatedMovie, Integer> {

    @Query("SELECT movie_id, title, rating, image FROM movie_detail WHERE title LIKE :keyword")
    Iterable<SearchRelatedMovie> findMoviesByKeyword(@Param("keyword") String keyword);

}
