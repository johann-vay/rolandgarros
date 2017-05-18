/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolandgarros.controller;

import fr.rolandgarros.dao.entities.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import fr.rolangarros.dao.service.PlayerService;

@Controller
public class PlayerController {
	
	private PlayerService playerService;
	
	@Autowired(required=true)
	@Qualifier(value="playerService")
	public void setplayerService(PlayerService cs){
		this.playerService = cs;
	}
	
	@RequestMapping(value = "/players", method = RequestMethod.GET)
	public String listPlayers(Model model) {
		model.addAttribute("player", new Player());
		model.addAttribute("listPlayers", this.playerService.listPlayers());
		return "player";
	}
	
	//For add and update person both
	@RequestMapping(value= "/player/add", method = RequestMethod.POST)
	public String addPlayer(@ModelAttribute("player") Player c){
		
		if(c.getIdPlayer() == 0){
			//new player, add it
			this.playerService.addPlayer(c);
		}else{
			//existing player, call update
			this.playerService.updatePlayer(c);
		}
		
		return "redirect:/player"; //page jsp 
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removePlayer(@PathVariable("id") int id){
		
        this.playerService.removePlayer(id);
        return "redirect:/players"; //page jsp 
    }
 
    @RequestMapping("/edit/{id}")
    public String editPlayer(@PathVariable("id") int id, Model model){
        model.addAttribute("player", this.playerService.findPlayerById(id));
        model.addAttribute("listPlayers", this.playerService.listPlayers());
        return "player";
    }
	
}
