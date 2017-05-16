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
@Table(name = "tournament")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tournament.findAll", query = "SELECT t FROM Tournament t"),
    @NamedQuery(name = "Tournament.findByIdTournament", query = "SELECT t FROM Tournament t WHERE t.idTournament = :idTournament"),
    @NamedQuery(name = "Tournament.findByLabel", query = "SELECT t FROM Tournament t WHERE t.label = :label"),
    @NamedQuery(name = "Tournament.findByVersion", query = "SELECT t FROM Tournament t WHERE t.version = :version")})
public class Tournament implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTournament")
    private Integer idTournament;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "label")
    private String label;
    @Basic(optional = false)
    @NotNull
    @Column(name = "version")
    @Version
    private int version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTournament", fetch = FetchType.LAZY)
    private List<Game> gameList;

    public Tournament() {
    }

    public Tournament(Integer idTournament) {
        this.idTournament = idTournament;
    }

    public Tournament(Integer idTournament, String label, int version) {
        this.idTournament = idTournament;
        this.label = label;
        this.version = version;
    }

    public Integer getIdTournament() {
        return idTournament;
    }

    public void setIdTournament(Integer idTournament) {
        this.idTournament = idTournament;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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
        hash += (idTournament != null ? idTournament.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tournament)) {
            return false;
        }
        Tournament other = (Tournament) object;
        if ((this.idTournament == null && other.idTournament != null) || (this.idTournament != null && !this.idTournament.equals(other.idTournament))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.rolandgarros.dao.entities.Tournament[ idTournament=" + idTournament + " ]";
    }
    
}
