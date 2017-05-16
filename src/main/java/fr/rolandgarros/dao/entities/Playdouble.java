/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolandgarros.dao.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Johann
 */
@Entity
@Table(name = "playdouble")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Playdouble.findAll", query = "SELECT p FROM Playdouble p"),
    @NamedQuery(name = "Playdouble.findByIdTeam", query = "SELECT p FROM Playdouble p WHERE p.playdoublePK.idTeam = :idTeam"),
    @NamedQuery(name = "Playdouble.findByIdGame", query = "SELECT p FROM Playdouble p WHERE p.playdoublePK.idGame = :idGame"),
    @NamedQuery(name = "Playdouble.findByNbSetWon", query = "SELECT p FROM Playdouble p WHERE p.nbSetWon = :nbSetWon"),
    @NamedQuery(name = "Playdouble.findByWinner", query = "SELECT p FROM Playdouble p WHERE p.winner = :winner")})
public class Playdouble implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PlaydoublePK playdoublePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nbSetWon")
    private int nbSetWon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "winner")
    private boolean winner;
    @JoinColumn(name = "idGame", referencedColumnName = "idGame", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Game game;
    @JoinColumn(name = "idTeam", referencedColumnName = "idTeam", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Team team;

    public Playdouble() {
    }

    public Playdouble(PlaydoublePK playdoublePK) {
        this.playdoublePK = playdoublePK;
    }

    public Playdouble(PlaydoublePK playdoublePK, int nbSetWon, boolean winner) {
        this.playdoublePK = playdoublePK;
        this.nbSetWon = nbSetWon;
        this.winner = winner;
    }

    public Playdouble(int idTeam, int idGame) {
        this.playdoublePK = new PlaydoublePK(idTeam, idGame);
    }

    public PlaydoublePK getPlaydoublePK() {
        return playdoublePK;
    }

    public void setPlaydoublePK(PlaydoublePK playdoublePK) {
        this.playdoublePK = playdoublePK;
    }

    public int getNbSetWon() {
        return nbSetWon;
    }

    public void setNbSetWon(int nbSetWon) {
        this.nbSetWon = nbSetWon;
    }

    public boolean getWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (playdoublePK != null ? playdoublePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Playdouble)) {
            return false;
        }
        Playdouble other = (Playdouble) object;
        if ((this.playdoublePK == null && other.playdoublePK != null) || (this.playdoublePK != null && !this.playdoublePK.equals(other.playdoublePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.rolandgarros.dao.entities.Playdouble[ playdoublePK=" + playdoublePK + " ]";
    }
    
}
