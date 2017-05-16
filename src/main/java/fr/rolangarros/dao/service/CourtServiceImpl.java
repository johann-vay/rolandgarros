/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolangarros.dao.service;

import fr.rolandgarros.dao.entities.Court;
import fr.rolandgarros.dao.dao.CourtDao;
import java.util.List;

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
    public Court addCourt(Court c) {
        return this.courtDao.addCourt(c);
    }

    @Override
    public Court updateCourt(Court c) {
        return this.courtDao.updateCourt(c);
    }

    @Override
    public List<Court> listCourts() {
        return this.courtDao.findAll();
    }

    @Override
    public Court findCourtById(int id) {
        return this.courtDao.findCourtById(id);
    }

    @Override
    public boolean removeCourt(int id) {
        return this.courtDao.removeCourt(id);
    }
    
}
