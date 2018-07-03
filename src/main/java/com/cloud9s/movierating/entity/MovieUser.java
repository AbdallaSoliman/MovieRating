/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloud9s.movierating.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "movie_user", catalog = "movierating", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MovieUser.findAll", query = "SELECT m FROM MovieUser m")
    , @NamedQuery(name = "MovieUser.findByUserId", query = "SELECT m FROM MovieUser m WHERE m.userId = :userId")
    , @NamedQuery(name = "MovieUser.findByFirstName", query = "SELECT m FROM MovieUser m WHERE m.firstName = :firstName")
    , @NamedQuery(name = "MovieUser.findByLastName", query = "SELECT m FROM MovieUser m WHERE m.lastName = :lastName")
    , @NamedQuery(name = "MovieUser.findByTitle", query = "SELECT m FROM MovieUser m WHERE m.title = :title")
    , @NamedQuery(name = "MovieUser.findByCountry", query = "SELECT m FROM MovieUser m WHERE m.country = :country")
    , @NamedQuery(name = "MovieUser.findByPassword", query = "SELECT m FROM MovieUser m WHERE m.password = :password")
    , @NamedQuery(name = "MovieUser.findByImageURL", query = "SELECT m FROM MovieUser m WHERE m.imageURL = :imageURL")
    , @NamedQuery(name = "MovieUser.findByEmail", query = "SELECT m FROM MovieUser m WHERE m.email = :email")})
public class MovieUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @Size(max = 35)
    @Column(name = "first_name")
    private String firstName;
    @Size(max = 35)
    @Column(name = "last_name")
    private String lastName;
    @Size(max = 100)
    @Column(name = "title")
    private String title;
    @Size(max = 35)
    @Column(name = "country")
    private String country;
    @Size(max = 80)
    @Column(name = "password")
    private String password;
    @Size(max = 150)
    @Column(name = "imageURL")
    private String imageURL;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @JoinTable(name = "watched", joinColumns = {
        @JoinColumn(name = "user_id", referencedColumnName = "user_id")}, inverseJoinColumns = {
        @JoinColumn(name = "movie_id", referencedColumnName = "movie_id")})
    @ManyToMany
    private Collection<Movie> movieCollection;
    @JoinTable(name = "rate", joinColumns = {
        @JoinColumn(name = "user_id", referencedColumnName = "user_id")}, inverseJoinColumns = {
        @JoinColumn(name = "movie_id", referencedColumnName = "movie_id")})
    @ManyToMany
    private Collection<Movie> movieCollection1;
    @OneToMany(mappedBy = "userId")
    private Collection<Comment> commentCollection;
    @OneToMany(mappedBy = "userId")
    private Collection<Roule> rouleCollection;

    public MovieUser() {
    }

    public MovieUser(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<Movie> getMovieCollection() {
        return movieCollection;
    }

    public void setMovieCollection(Collection<Movie> movieCollection) {
        this.movieCollection = movieCollection;
    }

    @XmlTransient
    public Collection<Movie> getMovieCollection1() {
        return movieCollection1;
    }

    public void setMovieCollection1(Collection<Movie> movieCollection1) {
        this.movieCollection1 = movieCollection1;
    }

    @XmlTransient
    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }

    @XmlTransient
    public Collection<Roule> getRouleCollection() {
        return rouleCollection;
    }

    public void setRouleCollection(Collection<Roule> rouleCollection) {
        this.rouleCollection = rouleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovieUser)) {
            return false;
        }
        MovieUser other = (MovieUser) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cloud9s.movierating.entity.MovieUser[ userId=" + userId + " ]";
    }
    
}
