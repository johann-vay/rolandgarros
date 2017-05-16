/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolangarros.dao.service;

import fr.rolandgarros.dao.entities.Tournament;
import fr.rolandgarros.dao.dao.TournamentDao;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Johann
 */
public class TournamentServiceImpl implements TournamentService{

    private TournamentDao tournamentDao;
    
    public void getTournamentDao(){
        this.tournamentDao = new TournamentDao();
    }
    
    @Override
    @Transactional
    public Tournament addTournament(Tournament t) {
        return this.tournamentDao.addTournament(t);
    }

    @Override
    @Transactional
    public Tournament updateTournament(Tournament t) {
        return this.tournamentDao.updateTournament(t);
    }

    @Override
    @Transactional
    public List<Tournament> listTournaments() {
        return this.tournamentDao.findAll();
    }

    @Override
    @Transactional
    public Tournament findTournamentById(int id) {
        return this.tournamentDao.findTournamentById(id);
    }

    @Override
    @Transactional
    public boolean removeTournament(int id) {
        return this.tournamentDao.removeTournament(id);
    }
    
}
