/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolandgarros.controller;

import fr.rolandgarros.dao.entities.Tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import fr.rolangarros.dao.service.TournamentService;

@Controller
public class TournamentController {
	
	private TournamentService tournamentService;
	
	@Autowired(required=true)
	@Qualifier(value="tournamentService")
	public void settournamentService(TournamentService cs){
		this.tournamentService = cs;
	}
	
	@RequestMapping(value = "/tournaments", method = RequestMethod.GET)
	public String listTournaments(Model model) {
		model.addAttribute("tournament", new Tournament());
		model.addAttribute("listTournaments", this.tournamentService.listTournaments());
		return "tournament";
	}
	
	//For add and update person both
	@RequestMapping(value= "/tournament/add", method = RequestMethod.POST)
	public String addTournament(@ModelAttribute("tournament") Tournament c){
		
		if(c.getIdTournament() == 0){
			//new tournament, add it
			this.tournamentService.addTournament(c);
		}else{
			//existing tournament, call update
			this.tournamentService.updateTournament(c);
		}
		
		return "redirect:/tournament"; //page jsp 
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removeTournament(@PathVariable("id") int id){
		
        this.tournamentService.removeTournament(id);
        return "redirect:/tournaments"; //page jsp 
    }
 
    @RequestMapping("/edit/{id}")
    public String editTournament(@PathVariable("id") int id, Model model){
        model.addAttribute("tournament", this.tournamentService.findTournamentById(id));
        model.addAttribute("listTournaments", this.tournamentService.listTournaments());
        return "tournament";
    }
	
}
