/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolangarros.dao.service;

import fr.rolandgarros.dao.entities.Playdouble;
import fr.rolandgarros.dao.dao.PlayDoubleDao;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Johann
 */
public class PlayDoubleServiceImpl implements PlayDoubleService {

    private PlayDoubleDao playdoubleDao;
    
    public void getPlaydoubleDao(){
        this.playdoubleDao = new PlayDoubleDao();
    }
    
    @Override
    @Transactional
    public Playdouble addPlaydouble(Playdouble p) {
        return (Playdouble) this.playdoubleDao.create(Playdouble.class);
    }

    @Override
    @Transactional
    public Playdouble updatePlaydouble(Playdouble p) {
        return (Playdouble) this.playdoubleDao.update(p);
    }

    @Override
    @Transactional
    public List<Playdouble> listPlaydouble() {
        return this.playdoubleDao.findAll(Playdouble.class);
    }

    @Override
    @Transactional
    public Playdouble findPlaydouble(int idTeam, int idGame) {
        return (Playdouble) this.playdoubleDao.findById(Playdouble.class, idGame/*, idTeam*/);
    }

    /*@Override
    @Transactional
    public boolean removePlaydouble(int idTeam, int idGame) {
        return this.playdoubleDao.delete(idTeam, idGame;
    }*/
    
}
