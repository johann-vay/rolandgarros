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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "referee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Referee.findAll", query = "SELECT r FROM Referee r"),
    @NamedQuery(name = "Referee.findByIdReferee", query = "SELECT r FROM Referee r WHERE r.idReferee = :idReferee"),
    @NamedQuery(name = "Referee.findByFirstname", query = "SELECT r FROM Referee r WHERE r.firstname = :firstname"),
    @NamedQuery(name = "Referee.findByName", query = "SELECT r FROM Referee r WHERE r.name = :name"),
    @NamedQuery(name = "Referee.findByVersion", query = "SELECT r FROM Referee r WHERE r.version = :version")})
public class Referee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idReferee")
    private Integer idReferee;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "firstname")
    private String firstname;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idReferee", fetch = FetchType.LAZY)
    private List<Game> gameList;
    @JoinColumn(name = "idCountry", referencedColumnName = "idCountry")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Country idCountry;

    public Referee() {
    }

    public Referee(Integer idReferee) {
        this.idReferee = idReferee;
    }

    public Referee(Integer idReferee, String firstname, String name, int version) {
        this.idReferee = idReferee;
        this.firstname = firstname;
        this.name = name;
        this.version = version;
    }

    public Integer getIdReferee() {
        return idReferee;
    }

    public void setIdReferee(Integer idReferee) {
        this.idReferee = idReferee;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
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

    public Country getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Country idCountry) {
        this.idCountry = idCountry;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReferee != null ? idReferee.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Referee)) {
            return false;
        }
        Referee other = (Referee) object;
        if ((this.idReferee == null && other.idReferee != null) || (this.idReferee != null && !this.idReferee.equals(other.idReferee))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.rolandgarros.dao.entities.Referee[ idReferee=" + idReferee + " ]";
    }
    
}
