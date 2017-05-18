/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolangarros.dao.service;

import fr.rolandgarros.dao.entities.Team;
import fr.rolandgarros.dao.dao.TeamDao;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Johann
 */
public class TeamServiceImpl implements TeamService {

    private TeamDao teamDao;
    
    public TeamDao getTeamDao(){
        this.teamDao = new TeamDao();
        return this.teamDao;
    }
    
    @Override
    @Transactional
    public Team addTeam(Team t) {
        return (Team) this.teamDao.create(t);
    }

    @Override
    @Transactional
    public Team updateTeam(Team t) {
        return (Team) this.teamDao.update(t);
    }

    @Override
    @Transactional
    public List<Team> listTeams() {
        return this.teamDao.findAll(Team.class);
    }

    @Override
    @Transactional
    public Team findTeamById(int id) {
        return (Team) this.teamDao.findById(Team.class, id);
    }

    @Override
    @Transactional
    public boolean removeTeam(int id) {
        return this.teamDao.delete(id);
    }
    
}
