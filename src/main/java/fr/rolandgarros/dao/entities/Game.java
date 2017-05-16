/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolandgarros.dao.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Johann
 */
@Entity
@Table(name = "game")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Game.findAll", query = "SELECT g FROM Game g"),
    @NamedQuery(name = "Game.findByIdGame", query = "SELECT g FROM Game g WHERE g.idGame = :idGame"),
    @NamedQuery(name = "Game.findByStartDate", query = "SELECT g FROM Game g WHERE g.startDate = :startDate"),
    @NamedQuery(name = "Game.findByEndDate", query = "SELECT g FROM Game g WHERE g.endDate = :endDate"),
    @NamedQuery(name = "Game.findByVersion", query = "SELECT g FROM Game g WHERE g.version = :version")})
public class Game implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idGame")
    private Integer idGame;
    @Basic(optional = false)
    @NotNull
    @Column(name = "startDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "endDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "version")
    @Version
    private int version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "game", fetch = FetchType.LAZY)
    private List<Play> playList;
    @JoinColumn(name = "idCourt", referencedColumnName = "idCourt")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Court idCourt;
    @JoinColumn(name = "idReferee", referencedColumnName = "idReferee")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Referee idReferee;
    @JoinColumn(name = "idTournament", referencedColumnName = "idTournament")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tournament idTournament;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "game", fetch = FetchType.LAZY)
    private List<Playdouble> playdoubleList;

    public Game() {
    }

    public Game(Integer idGame) {
        this.idGame = idGame;
    }

    public Game(Integer idGame, Date startDate, Date endDate, int version) {
        this.idGame = idGame;
        this.startDate = startDate;
        this.endDate = endDate;
        this.version = version;
    }

    public Integer getIdGame() {
        return idGame;
    }

    public void setIdGame(Integer idGame) {
        this.idGame = idGame;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @XmlTransient
    public List<Play> getPlayList() {
        return playList;
    }

    public void setPlayList(List<Play> playList) {
        this.playList = playList;
    }

    public Court getIdCourt() {
        return idCourt;
    }

    public void setIdCourt(Court idCourt) {
        this.idCourt = idCourt;
    }

    public Referee getIdReferee() {
        return idReferee;
    }

    public void setIdReferee(Referee idReferee) {
        this.idReferee = idReferee;
    }

    public Tournament getIdTournament() {
        return idTournament;
    }

    public void setIdTournament(Tournament idTournament) {
        this.idTournament = idTournament;
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
        hash += (idGame != null ? idGame.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Game)) {
            return false;
        }
        Game other = (Game) object;
        if ((this.idGame == null && other.idGame != null) || (this.idGame != null && !this.idGame.equals(other.idGame))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.rolandgarros.dao.entities.Game[ idGame=" + idGame + " ]";
    }
    
}
