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
        return (Tournament) this.tournamentDao.create(t);
    }

    @Override
    @Transactional
    public Tournament updateTournament(Tournament t) {
        return (Tournament) this.tournamentDao.update(t);
    }

    @Override
    @Transactional
    public List<Tournament> listTournaments() {
        return this.tournamentDao.findAll(Tournament.class);
    }

    @Override
    @Transactional
    public Tournament findTournamentById(int id) {
        return (Tournament) this.tournamentDao.findById(Tournament.class, id);
    }

    @Override
    @Transactional
    public boolean removeTournament(int id) {
        return this.tournamentDao.delete(id);
    }
    
}
