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
@Table(name = "play")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Play.findAll", query = "SELECT p FROM Play p"),
    @NamedQuery(name = "Play.findByIdPlayer", query = "SELECT p FROM Play p WHERE p.playPK.idPlayer = :idPlayer"),
    @NamedQuery(name = "Play.findByIdGame", query = "SELECT p FROM Play p WHERE p.playPK.idGame = :idGame"),
    @NamedQuery(name = "Play.findByNbSetWon", query = "SELECT p FROM Play p WHERE p.nbSetWon = :nbSetWon"),
    @NamedQuery(name = "Play.findByWinner", query = "SELECT p FROM Play p WHERE p.winner = :winner")})
public class Play implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PlayPK playPK;
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
    @JoinColumn(name = "idPlayer", referencedColumnName = "idPlayer", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Player player;

    public Play() {
    }

    public Play(PlayPK playPK) {
        this.playPK = playPK;
    }

    public Play(PlayPK playPK, int nbSetWon, boolean winner) {
        this.playPK = playPK;
        this.nbSetWon = nbSetWon;
        this.winner = winner;
    }

    public Play(int idPlayer, int idGame) {
        this.playPK = new PlayPK(idPlayer, idGame);
    }

    public PlayPK getPlayPK() {
        return playPK;
    }

    public void setPlayPK(PlayPK playPK) {
        this.playPK = playPK;
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

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (playPK != null ? playPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Play)) {
            return false;
        }
        Play other = (Play) object;
        if ((this.playPK == null && other.playPK != null) || (this.playPK != null && !this.playPK.equals(other.playPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.rolandgarros.dao.entities.Play[ playPK=" + playPK + " ]";
    }
    
}
