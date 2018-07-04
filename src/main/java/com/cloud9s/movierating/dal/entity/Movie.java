/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloud9s.movierating.dal.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author abdalla
 */
@Entity
@Table(name = "movie", catalog = "movierating", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m")
    , @NamedQuery(name = "Movie.findByMovieId", query = "SELECT m FROM Movie m WHERE m.movieId = :movieId")
    , @NamedQuery(name = "Movie.findByImageURL", query = "SELECT m FROM Movie m WHERE m.imageURL = :imageURL")
    , @NamedQuery(name = "Movie.findByRate", query = "SELECT m FROM Movie m WHERE m.rate = :rate")
    , @NamedQuery(name = "Movie.findByYear", query = "SELECT m FROM Movie m WHERE m.year = :year")})
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "movie_id")
    private Integer movieId;
    @Size(max = 150)
    @Column(name = "imageURL")
    private String imageURL;
    @Column(name = "rate")
    private Integer rate;
    @Column(name = "year")
    private Integer year;
    @ManyToMany(mappedBy = "movieCollection")
    private Collection<MovieUser> movieUserCollection;
    @ManyToMany(mappedBy = "movieCollection1")
    private Collection<MovieUser> movieUserCollection1;
    @OneToMany(mappedBy = "movieId")
    private Collection<Comment> commentCollection;

    public Movie() {
    }

    public Movie(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @XmlTransient
    public Collection<MovieUser> getMovieUserCollection() {
        return movieUserCollection;
    }

    public void setMovieUserCollection(Collection<MovieUser> movieUserCollection) {
        this.movieUserCollection = movieUserCollection;
    }

    @XmlTransient
    public Collection<MovieUser> getMovieUserCollection1() {
        return movieUserCollection1;
    }

    public void setMovieUserCollection1(Collection<MovieUser> movieUserCollection1) {
        this.movieUserCollection1 = movieUserCollection1;
    }

    @XmlTransient
    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movieId != null ? movieId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movie)) {
            return false;
        }
        Movie other = (Movie) object;
        if ((this.movieId == null && other.movieId != null) || (this.movieId != null && !this.movieId.equals(other.movieId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cloud9s.movierating.entity.Movie[ movieId=" + movieId + " ]";
    }
    
}
