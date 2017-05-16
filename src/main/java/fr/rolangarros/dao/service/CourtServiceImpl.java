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
    
    public void setCourtDao(CourtDao courtDao){
        this.courtDao = courtDao;
    }
    
    @Override
    @Transactional
    public Court addCourt(Court c) {
        return this.courtDao.addCourt(c);
    }

    @Override
    @Transactional
    public Court updateCourt(Court c) {
        return this.courtDao.updateCourt(c);
    }

    @Override
    @Transactional
    public List<Court> listCourts() {
        return this.courtDao.findAll();
    }

    @Override
    @Transactional
    public Court findCourtById(int id) {
        return this.courtDao.findCourtById(id);
    }

    @Override
    @Transactional
    public boolean removeCourt(int id) {
        return this.courtDao.removeCourt(id);
    }
    
}
