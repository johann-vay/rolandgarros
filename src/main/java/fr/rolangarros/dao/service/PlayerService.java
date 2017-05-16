/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolangarros.dao.service;

import fr.rolandgarros.dao.entities.Player;
import java.util.List;

/**
 *
 * @author Johann
 */
public interface PlayerService {
    public Player addPlayer(Player p);
    public Player updatePlayer(Player p);
    public List<Player> listPlayers();
    public Player findPlayerById(int id);
    public boolean removePlayer(int id);
}
