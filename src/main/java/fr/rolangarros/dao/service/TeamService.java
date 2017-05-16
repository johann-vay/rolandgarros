/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolangarros.dao.service;

import fr.rolandgarros.dao.entities.Team;
import java.util.List;

/**
 *
 * @author Johann
 */
public interface TeamService {
    public Team addTeam(Team t);
    public Team updateTeam(Team t);
    public List<Team> listTeams();
    public Team findTeamById(int id);
    public boolean removeTeam(int id);
}
