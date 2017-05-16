/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolangarros.dao.service;


import fr.rolandgarros.dao.entities.Game;
import fr.rolandGarros.dao.dao.GameDao;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Johann
 */
public class GameServiceImpl implements GameService{

    private GameDao gameDao;
    
    public void setGameDao(GameDao gameDao){
        this.gameDao = gameDao;
    }
    
    
    @Override
    @Transactional
    public Game addGame(Game g) {
        return this.gameDao.addGame(g);
    }

    @Override
    @Transactional
    public Game updateGame(Game g) {
        return this.gameDao.updateGame(g);
    }

    @Override
    @Transactional
    public List<Game> listGames() {
        return this.gameDao.findAll();
    }

    @Override
    @Transactional
    public Game findGameById(int id) {
        return this.gameDao.findGameById(id);
    }

    @Override
    @Transactional
    public boolean removeGame(int id) {
        return this.gameDao.removeGame(id);
    }
}
