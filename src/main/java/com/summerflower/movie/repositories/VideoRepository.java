package com.summerflower.movie.repositories;

import com.summerflower.movie.entities.Video;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface VideoRepository extends CrudRepository<Video, Integer> {

    @Query("SELECT movie_id, platform_name, video_link, is_free FROM video_watching WHERE movie_id = :id")
    Iterable<Video> findVideosById(@Param("id") int id);
}
