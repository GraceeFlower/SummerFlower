package com.summerflower.movie.repositories;

import com.summerflower.movie.entities.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Integer> {

}
