/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloud9s.movierating.dal.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author abdalla
 */
@Entity
@Table(name = "roule", catalog = "movierating", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roule.findAll", query = "SELECT r FROM Roule r")
    , @NamedQuery(name = "Roule.findByRouleId", query = "SELECT r FROM Roule r WHERE r.rouleId = :rouleId")
    , @NamedQuery(name = "Roule.findByName", query = "SELECT r FROM Roule r WHERE r.name = :name")})
public class Roule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "roule_id")
    private Integer rouleId;
    @Size(max = 35)
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne
    private MovieUser userId;

    public Roule() {
    }

    public Roule(Integer rouleId) {
        this.rouleId = rouleId;
    }

    public Integer getRouleId() {
        return rouleId;
    }

    public void setRouleId(Integer rouleId) {
        this.rouleId = rouleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MovieUser getUserId() {
        return userId;
    }

    public void setUserId(MovieUser userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rouleId != null ? rouleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roule)) {
            return false;
        }
        Roule other = (Roule) object;
        if ((this.rouleId == null && other.rouleId != null) || (this.rouleId != null && !this.rouleId.equals(other.rouleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cloud9s.movierating.entity.Roule[ rouleId=" + rouleId + " ]";
    }
    
}
