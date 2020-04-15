package com.summerflower.movie.entities;

public class Review {

    private int movieId;
    private String userName;
    private String commentTitle;
    private String commentContent;

    public Review() {
    }

    public Review(int movieId, String userName, String commentTitle, String commentContent) {
        this.movieId = movieId;
        this.userName = userName;
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
