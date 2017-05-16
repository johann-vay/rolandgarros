/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolangarros.dao.service;

import fr.rolandgarros.dao.entities.Play;
import fr.rolandgarros.dao.dao.PlayDao;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Johann
 */
public class PlayServiceImpl implements PlayService {

    private PlayDao playDao;
    
    public void getPlayDao(){
        this.playDao = new PlayDao();
    }
    
    @Override
    @Transactional
    public Play addPlay(Play p) {
        return (Play) this.playDao.create(p);
    }

    @Override
    @Transactional
    public Play updatePlay(Play p) {
        return (Play) this.playDao.update(p);
    }

    @Override
    @Transactional
    public List<Play> listPlay() {
        return this.playDao.findAll(Play.class);
    }

    @Override
    @Transactional
    public Play findPlay(int idPlayer, int idGame) {
        return (Play) this.playDao.findById(Play.class, idGame);
    }

    @Override
    @Transactional
    public boolean removePlay(int idPlayer, int idGame) {
        return this.playDao.delete(idGame);
    }
    
}
