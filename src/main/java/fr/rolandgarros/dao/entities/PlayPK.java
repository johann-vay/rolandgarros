/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolandgarros.dao.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Johann
 */
@Embeddable
public class PlayPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPlayer")
    private int idPlayer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idGame")
    private int idGame;

    public PlayPK() {
    }

    public PlayPK(int idPlayer, int idGame) {
        this.idPlayer = idPlayer;
        this.idGame = idGame;
    }

    public int getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(int idPlayer) {
        this.idPlayer = idPlayer;
    }

    public int getIdGame() {
        return idGame;
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPlayer;
        hash += (int) idGame;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlayPK)) {
            return false;
        }
        PlayPK other = (PlayPK) object;
        if (this.idPlayer != other.idPlayer) {
            return false;
        }
        if (this.idGame != other.idGame) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.rolandgarros.dao.entities.PlayPK[ idPlayer=" + idPlayer + ", idGame=" + idGame + " ]";
    }
    
}
