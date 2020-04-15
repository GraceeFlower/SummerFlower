package com.summerflower.movie.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;


@Table("movie_detail")
public class Detail {

    @Id
    private int id;
    @Column("movie_id")
    private int movieId;
    private String title;
    @Column("origin_title")
    private String originTitle;
    private Date year;
    @Column("image")
    private String smallImage;
    @Column("directors")
    private String directorList;
    @Column("casts")
    private String castList;
    private String genres;
    @Column("countries")
    private String countryList;
    @Column("languages")
    private String languageList;
    private String duration;
    @Column("pubdates")
    private String publicDateList;
    @Column("rating")
    private float average;
    private String summary;

    public Detail() {
    }

    public Detail(int id, int movieId, String title, String originTitle, Date year, String smallImage, String directorList, String castList, String genres, String countryList, String languageList, String duration, String publicDateList, float average, String summary) {
        this.id = id;
        this.movieId = movieId;
        this.title = title;
        this.originTitle = originTitle;
        this.year = year;
        this.smallImage = smallImage;
        this.directorList = directorList;
        this.castList = castList;
        this.genres = genres;
        this.countryList = countryList;
        this.languageList = languageList;
        this.duration = duration;
        this.publicDateList = publicDateList;
        this.average = average;
        this.summary = summary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginTitle() {
        return originTitle;
    }

    public void setOriginTitle(String originTitle) {
        this.originTitle = originTitle;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getSmallImage() {
        return smallImage;
    }

    public void setSmallImage(String smallImage) {
        this.smallImage = smallImage;
    }

    public String getDirectorList() {
        return directorList;
    }

    public void setDirectorList(String directorList) {
        this.directorList = directorList;
    }

    public String getCastList() {
        return castList;
    }

    public void setCastList(String castList) {
        this.castList = castList;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getCountryList() {
        return countryList;
    }

    public void setCountryList(String countryList) {
        this.countryList = countryList;
    }

    public String getLanguageList() {
        return languageList;
    }

    public void setLanguageList(String languageList) {
        this.languageList = languageList;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPublicDateList() {
        return publicDateList;
    }

    public void setPublicDateList(String publicDateList) {
        this.publicDateList = publicDateList;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}