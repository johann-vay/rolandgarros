/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolangarros.dao.service;

import fr.rolandgarros.dao.entities.Play;
import java.util.List;

/**
 *
 * @author Johann
 */
public interface PlayService {
    public Play addPlay(Play p);
    public Play updatePlay(Play p);
    public List<Play> listPlay();
    public Play findPlay(int idPlayer, int idGame);
    public boolean removePlay(int idPlayer, int idGame);
}
