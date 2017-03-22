package com.newb.mybatis.db.entity;

import javax.persistence.*;

public class Movie {
    @Id
    private Integer id;

    @Column(name = "movie_name")
    private String movieName;

    @Column(name = "movie_link")
    private String movieLink;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return movie_name
     */
    public String getMovieName() {
        return movieName;
    }

    /**
     * @param movieName
     */
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    /**
     * @return movie_link
     */
    public String getMovieLink() {
        return movieLink;
    }

    /**
     * @param movieLink
     */
    public void setMovieLink(String movieLink) {
        this.movieLink = movieLink;
    }
}