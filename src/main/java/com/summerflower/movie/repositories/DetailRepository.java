package com.summerflower.movie.repositories;

import com.summerflower.movie.entities.Detail;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DetailRepository extends CrudRepository<Detail, Integer> {

    @Query("SELECT * FROM movie_detail WHERE movie_id = :id")
    Detail findDetailById(@Param("id") int id);
}
