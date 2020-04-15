package com.summerflower.movie.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("comment")
public class Comment {

    @Id
    @Column("movie_id")
    private int movieId;
    @Column("user_name")
    private String userName;
    @Column("user_avatar")
    private String userAvatar;
    @Column("comment_title")
    private String commentTitle;
    @Column("comment_content")
    private String commentContent;

    public Comment() {
    }

    public Comment(int movieId, String userName, String userAvatar, String commentTitle, String commentContent) {
        this.movieId = movieId;
        this.userName = userName;
        this.userAvatar = userAvatar;
        this.commentTitle = commentTitle;
        this.commentContent = commentContent;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getCommentTitle() {
        return commentTitle;
    }

    public void setCommentTitle(String commentTitle) {
        this.commentTitle = commentTitle;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
}
