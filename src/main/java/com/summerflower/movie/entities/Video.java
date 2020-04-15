package com.summerflower.movie.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("video_watching")
public class Video {

    @Id
    @Column("movie_id")
    private int id;
    @Column("platform_name")
    private String platform;
    @Column("video_link")
    private String link;
    @Column("is_free")
    private boolean isFree;

    public Video() {
    }

    public Video(int id, String platform, String link, boolean isFree) {
        this.id = id;
        this.platform = platform;
        this.link = link;
        this.isFree = isFree;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }
}
