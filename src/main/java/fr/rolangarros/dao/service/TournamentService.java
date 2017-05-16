/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolangarros.dao.service;

import fr.rolandgarros.dao.entities.Tournament;
import java.util.List;

/**
 *
 * @author Johann
 */
public interface TournamentService {
    public Tournament addTournament(Tournament t);
    public Tournament updateTournament(Tournament t);
    public List<Tournament> listTournaments();
    public Tournament findTournamentById(int id);
    public boolean removeTournament(int id);
}
