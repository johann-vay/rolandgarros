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
    
    public RefereeDao getRefereeDao(){
        this.refereeDao = new RefereeDao();
        return this.refereeDao;
    }
    
    @Override
    @Transactional
    public Referee addReferee(Referee r) {
        return (Referee) this.refereeDao.create(r);
    }

    @Override
    @Transactional
    public Referee updateReferee(Referee r) {
        return (Referee) this.refereeDao.update(r);
    }

    @Override
    @Transactional
    public List<Referee> listReferees() {
        return this.refereeDao.findAll(Referee.class);
    }

    @Override
    @Transactional
    public Referee findRefereeById(int id) {
        return (Referee) this.refereeDao.findById(Referee.class, id);
    }

    @Override
    @Transactional
    public boolean removeReferee(int id) {
        return this.refereeDao.delete(id);
    }
    
}
