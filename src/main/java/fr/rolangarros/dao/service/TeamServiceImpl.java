/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolangarros.dao.service;

import fr.rolandgarros.dao.entities.Team;
import fr.rolandggarros.dao.dao.TeamDao;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Johann
 */
public class TeamServiceImpl implements TeamService {

    private TeamDao teamDao;
    
    public void getTeamDao(){
        this.teamDao = new TeamDao();
    }
    
    @Override
    @Transactional
    public Team addTeam(Team t) {
        return this.teamDao.addTeam(t);
    }

    @Override
    @Transactional
    public Team updateTeam(Team t) {
        return this.teamDao.updateTeam(t);
    }

    @Override
    @Transactional
    public List<Team> listTeams() {
        return this.teamDao.findAll();
    }

    @Override
    @Transactional
    public Team findTeamById(int id) {
        return this.teamDao.findTeamById(id);
    }

    @Override
    @Transactional
    public boolean removeTeam(int id) {
        return this.teamDao.removeTeam(id);
    }
    
}
