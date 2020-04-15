package com.summerflower.movie.repositories;

import com.summerflower.movie.entities.Movie;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MovieRepository extends CrudRepository<Movie, Integer> {

    @Query("SELECT movie_id, title, rating, genres, image FROM movie_detail ORDER BY rating DESC LIMIT :num")
    Iterable<Movie> findMovieInRange(@Param("num") Integer num);

    @Query("SELECT movie_id, title, rating, genres, image FROM movie_detail WHERE genres LIKE :type")
    Iterable<Movie> findMoviesByType(@Param("type") String type);

    @Query("SELECT movie_id, title, rating, genres, image FROM movie_detail WHERE movie_id != :id AND genres LIKE :type")
    Iterable<Movie> findSimilarMoviesByType(@Param("type") String type, @Param("id") int id);

}
