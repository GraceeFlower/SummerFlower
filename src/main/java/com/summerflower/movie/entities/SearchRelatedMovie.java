package com.summerflower.movie.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("movie_detail")
public class SearchRelatedMovie {

    @Id
    @Column("movie_id")
    private int id;
    private String title;
    private float rating;
    private String image;

    public SearchRelatedMovie() {
    }

    public SearchRelatedMovie(int id, String title, float rating, String image) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
