package com.summerflower.movie.services;

import com.summerflower.movie.entities.Comment;
import com.summerflower.movie.repositories.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository commentRepository;


    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Iterable<Comment> getCommentsById(int id) {
        return commentRepository.findCommentsById(id);
    }
}
