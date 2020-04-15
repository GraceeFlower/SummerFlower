package com.summerflower.movie.repositories;

import com.summerflower.movie.entities.Comment;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CommentRepository extends CrudRepository<Comment, Integer> {

    @Query("SELECT movie_id, user_name, user_avatar, comment_title, comment_content FROM comment WHERE movie_id = :id")
    Iterable<Comment> findCommentsById(@Param("id") int id);
}
