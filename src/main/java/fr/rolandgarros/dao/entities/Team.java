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
import javax.persistence.ManyToMany;
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
@Table(name = "team")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Team.findAll", query = "SELECT t FROM Team t"),
    @NamedQuery(name = "Team.findByIdTeam", query = "SELECT t FROM Team t WHERE t.idTeam = :idTeam"),
    @NamedQuery(name = "Team.findByName", query = "SELECT t FROM Team t WHERE t.name = :name"),
    @NamedQuery(name = "Team.findByVersion", query = "SELECT t FROM Team t WHERE t.version = :version")})
public class Team implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTeam")
    private Integer idTeam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Column(name = "version")
    @Version
    private Integer version;
    @ManyToMany(mappedBy = "teamList", fetch = FetchType.LAZY)
    private List<Player> playerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "team", fetch = FetchType.LAZY)
    private List<Playdouble> playdoubleList;

    public Team() {
    }

    public Team(Integer idTeam) {
        this.idTeam = idTeam;
    }

    public Team(Integer idTeam, String name) {
        this.idTeam = idTeam;
        this.name = name;
    }

    public Integer getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(Integer idTeam) {
        this.idTeam = idTeam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @XmlTransient
    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    @XmlTransient
    public List<Playdouble> getPlaydoubleList() {
        return playdoubleList;
    }

    public void setPlaydoubleList(List<Playdouble> playdoubleList) {
        this.playdoubleList = playdoubleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTeam != null ? idTeam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Team)) {
            return false;
        }
        Team other = (Team) object;
        if ((this.idTeam == null && other.idTeam != null) || (this.idTeam != null && !this.idTeam.equals(other.idTeam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.rolandgarros.dao.entities.Team[ idTeam=" + idTeam + " ]";
    }
    
}
