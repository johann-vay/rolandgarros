/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolandgarros.controller;

import fr.rolandgarros.dao.entities.Referee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import fr.rolangarros.dao.service.RefereeService;

@Controller
public class RefereeController {
	
	private RefereeService refereeService;
	
	@Autowired(required=true)
	@Qualifier(value="refereeService")
	public void setrefereeService(RefereeService cs){
		this.refereeService = cs;
	}
	
	@RequestMapping(value = "/referees", method = RequestMethod.GET)
	public String listCountries(Model model) {
		model.addAttribute("referee", new Referee());
		model.addAttribute("listReferees", this.refereeService.listReferees());
		return "referee";
	}
	
	//For add and update person both
	@RequestMapping(value= "/referee/add", method = RequestMethod.POST)
	public String addReferee(@ModelAttribute("referee") Referee c){
		
		if(c.getIdReferee() == 0){
			//new referee, add it
			this.refereeService.addReferee(c);
		}else{
			//existing referee, call update
			this.refereeService.updateReferee(c);
		}
		
		return "redirect:/referee"; //page jsp 
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removeReferee(@PathVariable("id") int id){
		
        this.refereeService.removeReferee(id);
        return "redirect:/referees"; //page jsp 
    }
 
    @RequestMapping("/edit/{id}")
    public String editReferee(@PathVariable("id") int id, Model model){
        model.addAttribute("referee", this.refereeService.findRefereeById(id));
        model.addAttribute("listReferees", this.refereeService.listReferees());
        return "referee";
    }
	
}
