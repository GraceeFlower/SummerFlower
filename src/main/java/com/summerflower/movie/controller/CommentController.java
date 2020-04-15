package com.summerflower.movie.controller;

import com.summerflower.movie.entities.Comment;
import com.summerflower.movie.services.CommentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("movies/comment")
    public Iterable<Comment> getCommentsById(@RequestParam(name = "id") int id) {
        return commentService.getCommentsById(id);
    }
}
