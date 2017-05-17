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
    
    public PlayerDao getPlayerDao(){
        this.playerDao = new PlayerDao();
        return this.playerDao;
    }
    
    @Override
    @Transactional
    public Player addPlayer(Player p) {
        return (Player) this.playerDao.create(p);
    }

    @Override
    @Transactional
    public Player updatePlayer(Player p) {
        return (Player) this.playerDao.update(p);
    }

    @Override
    @Transactional
    public List<Player> listPlayers() {
        return this.playerDao.findAll(Player.class);
    }

    @Override
    @Transactional
    public Player findPlayerById(int id) {
        return (Player) this.playerDao.findById(Player.class, id);
    }

    @Override
    @Transactional
    public boolean removePlayer(int id) {
        return this.playerDao.delete(id);
    }
    
}
