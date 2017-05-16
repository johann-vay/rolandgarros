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
    
    public void setPlayDao(PlayDao playDao){
        this.playDao = playDao;
    }
    
    @Override
    @Transactional
    public Play addPlay(Play p) {
        return this.playDao.addPlay(p);
    }

    @Override
    @Transactional
    public Play updatePlay(Play p) {
        return this.playDao.updatePlay(p);
    }

    @Override
    @Transactional
    public List<Play> listPlay() {
        return this.playDao.findAll();
    }

    @Override
    @Transactional
    public Play findPlay(int idPlayer, int idGame) {
        return this.playDao.findPlay(idPlayer, idGame);
    }

    @Override
    @Transactional
    public boolean removePlay(int idPlayer, int idGame) {
        return this.playDao.removePlay(idPlayer, idGame);
    }
    
}
