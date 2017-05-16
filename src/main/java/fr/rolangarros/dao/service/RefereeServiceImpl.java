/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolangarros.dao.service;

import fr.rolandgarros.dao.entities.Referee;
import fr.rolandgarros.dao.dao.RefereeDao;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Johann
 */
public class RefereeServiceImpl implements RefereeService{

    private RefereeDao refereeDao;
    
    public void setRefereeDao(RefereeDao refereeDao){
        this.refereeDao = refereeDao;
    }
    
    @Override
    @Transactional
    public Referee addReferee(Referee r) {
        return this.refereeDao.addReferee(r);
    }

    @Override
    @Transactional
    public Referee updateReferee(Referee r) {
        return this.refereeDao.updateReferee(r);
    }

    @Override
    @Transactional
    public List<Referee> listReferees() {
        return this.refereeDao.findAll();
    }

    @Override
    @Transactional
    public Referee findRefereeById(int id) {
        return this.refereeDao.findRefereeById(id);
    }

    @Override
    @Transactional
    public boolean removeReferee(int id) {
        return this.refereeDao.removeReferee(id);
    }
    
}
