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
public class PlaydoublePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTeam")
    private int idTeam;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idGame")
    private int idGame;

    public PlaydoublePK() {
    }

    public PlaydoublePK(int idTeam, int idGame) {
        this.idTeam = idTeam;
        this.idGame = idGame;
    }

    public int getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(int idTeam) {
        this.idTeam = idTeam;
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
        hash += (int) idTeam;
        hash += (int) idGame;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlaydoublePK)) {
            return false;
        }
        PlaydoublePK other = (PlaydoublePK) object;
        if (this.idTeam != other.idTeam) {
            return false;
        }
        if (this.idGame != other.idGame) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.rolandgarros.dao.entities.PlaydoublePK[ idTeam=" + idTeam + ", idGame=" + idGame + " ]";
    }
    
}
