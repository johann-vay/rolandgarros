/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolandgarros.controller;

import fr.rolandgarros.dao.entities.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import fr.rolangarros.dao.service.GameService;

@Controller
public class GameController {
	
	private GameService gameService;
	
	@Autowired(required=true)
	@Qualifier(value="gameService")
	public void setgameService(GameService cs){
		this.gameService = cs;
	}
	
	@RequestMapping(value = "/games", method = RequestMethod.GET)
	public String listGames(Model model) {
		model.addAttribute("game", new Game());
		model.addAttribute("listGames", this.gameService.listGames());
		return "game";
	}
	
	//For add and update person both
	@RequestMapping(value= "/game/add", method = RequestMethod.POST)
	public String addGame(@ModelAttribute("game") Game c){
		
		if(c.getIdGame() == 0){
			//new game, add it
			this.gameService.addGame(c);
		}else{
			//existing game, call update
			this.gameService.updateGame(c);
		}
		
		return "redirect:/game"; //page jsp 
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removeGame(@PathVariable("id") int id){
		
        this.gameService.removeGame(id);
        return "redirect:/games"; //page jsp 
    }
 
    @RequestMapping("/edit/{id}")
    public String editGame(@PathVariable("id") int id, Model model){
        model.addAttribute("game", this.gameService.findGameById(id));
        model.addAttribute("listGames", this.gameService.listGames());
        return "game";
    }
	
}