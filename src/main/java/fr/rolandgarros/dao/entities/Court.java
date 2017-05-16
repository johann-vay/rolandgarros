/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolandgarros.dao.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Johann
 */
@Entity
@Table(name = "court")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Court.findAll", query = "SELECT c FROM Court c"),
    @NamedQuery(name = "Court.findByIdCourt", query = "SELECT c FROM Court c WHERE c.idCourt = :idCourt"),
    @NamedQuery(name = "Court.findByName", query = "SELECT c FROM Court c WHERE c.name = :name"),
    @NamedQuery(name = "Court.findByVersion", query = "SELECT c FROM Court c WHERE c.version = :version")})
public class Court implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCourt")
    private Integer idCourt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "version")
    @Version
    private int version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCourt", fetch = FetchType.LAZY)
    private List<Game> gameList;

    public Court() {
    }

    public Court(Integer idCourt) {
        this.idCourt = idCourt;
    }

    public Court(Integer idCourt, String name, int version) {
        this.idCourt = idCourt;
        this.name = name;
        this.version = version;
    }

    public Integer getIdCourt() {
        return idCourt;
    }

    public void setIdCourt(Integer idCourt) {
        this.idCourt = idCourt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @XmlTransient
    public List<Game> getGameList() {
        return gameList;
    }

    public void setGameList(List<Game> gameList) {
        this.gameList = gameList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCourt != null ? idCourt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Court)) {
            return false;
        }
        Court other = (Court) object;
        if ((this.idCourt == null && other.idCourt != null) || (this.idCourt != null && !this.idCourt.equals(other.idCourt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.rolandgarros.dao.entities.Court[ idCourt=" + idCourt + " ]";
    }
    
}
