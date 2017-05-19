/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolandgarros.controller;

import fr.rolandgarros.dao.dao.IPlayerDao;
import fr.rolandgarros.dao.entities.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import utils.Constants;

@Controller
public class PlayerController {
	
	private IPlayerDao playerDao;
	
	@Autowired(required=true)
	@Qualifier(value="playerDao")
	public void setplayerDao(){
		this.playerDao = (IPlayerDao) Constants.ctx.getBean("playerDao");
	}
	
	@RequestMapping(value = "/players", method = RequestMethod.GET)
	public String listPlayers(Model model) {
		model.addAttribute("listPlayers", this.playerDao.findAll(Player.class));
		return "player";
	}
	
	//For add and update player both
	@RequestMapping(value= "/player/add", method = RequestMethod.POST)
	public String addPlayer(@ModelAttribute("player") Player c){
		
		if(c.getIdPlayer() == 0){
			//new Player, add it
			this.playerDao.create(Player.class);
		}else{
			//existing Player, call update
			this.playerDao.update(Player.class);
		}
		
		return "redirect:/players"; //page jsp 
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removePlayer(@PathVariable("id") int id){
	Player player = (Player) this.playerDao.findById(Player.class, id);
        this.playerDao.delete(player);
        return "redirect:/players"; //page jsp 
    }
 
    @RequestMapping("/edit/{id}")
    public String editPlayer(@PathVariable("id") int id, Model model){
        model.addAttribute("players", this.playerDao.findById(Player.class, id));
        model.addAttribute("listPlayers", this.playerDao.findAll(Player.class));
        return "player";
    }
	
}