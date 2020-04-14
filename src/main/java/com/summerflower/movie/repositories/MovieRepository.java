package com.summerflower.movie.repositories;

import com.summerflower.movie.entities.Movie;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MovieRepository extends CrudRepository<Movie, Integer> {

    @Query("SELECT * FROM movies ORDER BY rating DESC LIMIT :num")
    Iterable<Movie> findMovieInRange(@Param("num") Integer num);

    @Query("SELECT * FROM movies WHERE genres LIKE :type")
    Iterable<Movie> findMoviesByType(@Param("type") String type);
}
