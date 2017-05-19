/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolandgarros.controller;

import fr.rolandgarros.dao.dao.IRefereeDao;
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
import utils.Constants;

@Controller
public class RefereeController {
	
	private IRefereeDao refereeDao;
	
	@Autowired(required=true)
	@Qualifier(value="refereeService")
	public void setrefereeService(RefereeService cs){
		this.refereeDao = (IRefereeDao) Constants.ctx.getBean("refereeDao");
	}
	
	@RequestMapping(value = "/referees", method = RequestMethod.GET)
	public String listReferees(Model model) {
		model.addAttribute("referee", new Referee());
		model.addAttribute("listReferees", this.refereeDao.findAll(Referee.class));
		return "referee";
	}
	
	//For add and update referee both
	@RequestMapping(value= "/referee/add", method = RequestMethod.POST)
	public String addReferee(@ModelAttribute("referee") Referee c){
		
		if(c.getIdReferee() == 0){
			//new referee, add it
			this.refereeDao.create(Referee.class);
		}else{
			//existing referee, call update
			this.refereeDao.update(Referee.class);
		}
		
		return "redirect:/referee"; //page jsp 
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removeReferee(@PathVariable("id") int id){
	Referee referee = (Referee) refereeDao.findById(Referee.class, id);
        this.refereeDao.delete(referee);
        return "redirect:/referees"; //page jsp 
    }
 
    @RequestMapping("/edit/{id}")
    public String editReferee(@PathVariable("id") int id, Model model){
        model.addAttribute("referee", this.refereeDao.findById(Referee.class,id));
        model.addAttribute("listReferees", this.refereeDao.findAll(Referee.class));
        return "referee";
    }
	
}
