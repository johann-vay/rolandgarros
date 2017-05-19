/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolandgarros.controller;

import fr.rolandgarros.dao.dao.ITeamDao;
import fr.rolandgarros.dao.entities.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import fr.rolangarros.dao.service.TeamService;
import utils.Constants;

@Controller
public class TeamController {
	
	private ITeamDao teamDao;
	
	@Autowired(required=true)
	@Qualifier(value="teamService")
	public void setteamService(TeamService cs){
		this.teamDao = (ITeamDao) Constants.ctx.getBean("teamDao");
	}
	
	@RequestMapping(value = "/teams", method = RequestMethod.GET)
	public String listTeams(Model model) {
		model.addAttribute("team", new Team());
		model.addAttribute("listTeams", this.teamDao.findAll(Team.class));
		return "team";
	}
	
	//For add and update team both
	@RequestMapping(value= "/team/add", method = RequestMethod.POST)
	public String addTeam(@ModelAttribute("team") Team c){
		
		if(c.getIdTeam() == 0){
			//new team, add it
			this.teamDao.create(Team.class);
		}else{
			//existing team, call update
			this.teamDao.update(Team.class);
		}
		
		return "redirect:/team"; //page jsp 
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removeTeam(@PathVariable("id") int id){
	Team team = (Team) teamDao.findById(Team.class, id);
        this.teamDao.delete(team);
        return "redirect:/teams"; //page jsp 
    }
 
    @RequestMapping("/edit/{id}")
    public String editTeam(@PathVariable("id") int id, Model model){
        model.addAttribute("team", this.teamDao.findById(Team.class,id));
        model.addAttribute("listTeams", this.teamDao.findAll(Team.class));
        return "team";
    }
	
}
