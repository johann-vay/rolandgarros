/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolangarros.dao.service;

import fr.rolandgarros.dao.entities.Court;
import fr.rolandgarros.dao.dao.CourtDao;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Johann
 */
public class CourtServiceImpl implements CourtService {

    private CourtDao courtDao;
    
    public void getCourtDao(){
        this.courtDao = new CourtDao();
    }
    
    @Override
    @Transactional
    public Court addCourt(Court c) {
        return (Court) this.courtDao.create(c);
    }

    @Override
    @Transactional
    public Court updateCourt(Court c) {
        return (Court) this.courtDao.update(c);
    }

    @Override
    @Transactional
    public List<Court> listCourts() {
        return this.courtDao.findAll(Court.class);
    }

    @Override
    @Transactional
    public Court findCourtById(int id) {
        return (Court) this.courtDao.findById(Court.class, id);
    }

    @Override
    @Transactional
    public boolean removeCourt(int id) {
        return this.courtDao.delete(id);
    }
    
}
