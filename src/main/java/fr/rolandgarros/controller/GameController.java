/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolandgarros.controller;

import fr.rolandgarros.dao.dao.IGameDao;
import fr.rolandgarros.dao.entities.Game;
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
public class GameController {
	
	private IGameDao gameDao;
	
	@Autowired(required=true)
	@Qualifier(value="gameDao")
	public void setgameDao(){
		this.gameDao = (IGameDao) Constants.ctx.getBean("gameDao");
	}
	
	@RequestMapping(value = "/games", method = RequestMethod.GET)
	public String listGames(Model model) {
		model.addAttribute("listGames", this.gameDao.findAll(Game.class));
		return "game";
	}
	
	//For add and update game both
	@RequestMapping(value= "/game/add", method = RequestMethod.POST)
	public String addGame(@ModelAttribute("game") Game c){
		
		if(c.getIdGame() == 0){
			//new Game, add it
			this.gameDao.create(Game.class);
		}else{
			//existing Game, call update
			this.gameDao.update(Game.class);
		}
		
		return "redirect:/games"; //page jsp 
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removeGame(@PathVariable("id") int id){
	Game game = (Game) this.gameDao.findById(Game.class, id);
        this.gameDao.delete(game);
        return "redirect:/games"; //page jsp 
    }
 
    @RequestMapping("/edit/{id}")
    public String editGame(@PathVariable("id") int id, Model model){
        model.addAttribute("games", this.gameDao.findById(Game.class, id));
        model.addAttribute("listGames", this.gameDao.findAll(Game.class));
        return "game";
    }
	
}