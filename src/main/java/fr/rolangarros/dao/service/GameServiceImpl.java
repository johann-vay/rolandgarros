/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolangarros.dao.service;


import fr.rolandgarros.dao.entities.Game;
import fr.rolandgarros.dao.dao.GameDao;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Johann
 */
public class GameServiceImpl implements GameService{

    private GameDao gameDao;
    
    public GameDao getGameDao(){
        this.gameDao = new GameDao();
        return this.gameDao;
    }
    
    
    @Override
    @Transactional
    public Game addGame(Game g) {
        return (Game) this.gameDao.create(g);
    }

    @Override
    @Transactional
    public Game updateGame(Game g) {
        return (Game) this.gameDao.update(g);
    }

    @Override
    @Transactional
    public List<Game> listGames() {
        return this.gameDao.findAll(Game.class);
    }

    @Override
    @Transactional
    public Game findGameById(int id) {
        return (Game) this.gameDao.findById(Game.class, id);
    }

    @Override
    @Transactional
    public boolean removeGame(int id) {
        return this.gameDao.delete(id);
    }
}
