/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolangarros.dao.service;

import fr.rolandgarros.dao.entities.Player;
import fr.rolandgarros.dao.dao.PlayerDao;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Johann
 */
public class PlayerServiceImpl implements PlayerService {

    private PlayerDao playerDao;
    
    public void getPlayerDao(){
        this.playerDao = new PlayerDao();
    }
    
    @Override
    @Transactional
    public Player addPlayer(Player p) {
        return this.playerDao.addPlayer(p);
    }

    @Override
    @Transactional
    public Player updatePlayer(Player p) {
        return this.playerDao.updatePlayer(p);
    }

    @Override
    @Transactional
    public List<Player> listPlayers() {
        return this.playerDao.findAll();
    }

    @Override
    @Transactional
    public Player findPlayerById(int id) {
        return this.playerDao.findPlayerById(id);
    }

    @Override
    @Transactional
    public boolean removePlayer(int id) {
        return this.playerDao.removePlayer(id);
    }
    
}
