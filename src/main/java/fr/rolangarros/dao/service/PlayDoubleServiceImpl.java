/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolangarros.dao.service;

import fr.rolandgarros.dao.entities.Playdouble;
import fr.roland.garros.dao.dao.PlaydoubleDao;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Johann
 */
public class PlayDoubleServiceImpl implements PlayDoubleService {

    private PlaydoubleDao playdoubleDao;
    
    public void setPlaydubleDao(PlaydoubleDao playdoubleDao){
        this.playdoubleDao = playdoubleDao;
    }
    
    @Override
    @Transactional
    public Playdouble addPlaydouble(Playdouble p) {
        return this.playdoubleDao.addPlaydouble(p);
    }

    @Override
    @Transactional
    public Playdouble updatePlaydouble(Playdouble p) {
        return this.playdoubleDao.updatePlaydouble(p);
    }

    @Override
    @Transactional
    public List<Playdouble> listPlaydouble() {
        return this.playdoubleDao.findAll();
    }

    @Override
    @Transactional
    public Playdouble findPlaydouble(int idTeam, int idGame) {
        return this.playdoubleDao.findPlayDouble(idTeam, idGame);
    }

    @Override
    @Transactional
    public boolean removePlaydouble(int idTeam, int idGame) {
        return this.playdoubleDao.removePlaydouble(idTeam, idGame);
    }
    
}
