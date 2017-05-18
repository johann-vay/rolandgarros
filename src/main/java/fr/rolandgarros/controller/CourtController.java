/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolandgarros.controller;

import fr.rolandgarros.dao.entities.Court;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import fr.rolangarros.dao.service.CourtService;

@Controller
public class CourtController {
	
	private CourtService courtService;
	
	@Autowired(required=true)
	@Qualifier(value="courtService")
	public void setcourtService(CourtService cs){
		this.courtService = cs;
	}
	
	@RequestMapping(value = "/courts", method = RequestMethod.GET)
	public String listCourts(Model model) {
		model.addAttribute("court", new Court());
		model.addAttribute("listCourts", this.courtService.listCourts());
		return "court";
	}
	
	//For add and update person both
	@RequestMapping(value= "/court/add", method = RequestMethod.POST)
	public String addCourt(@ModelAttribute("court") Court c){
		
		if(c.getIdCourt() == 0){
			//new court, add it
			this.courtService.addCourt(c);
		}else{
			//existing court, call update
			this.courtService.updateCourt(c);
		}
		
		return "redirect:/court"; //page jsp 
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removeCourt(@PathVariable("id") int id){
		
        this.courtService.removeCourt(id);
        return "redirect:/courts"; //page jsp 
    }
 
    @RequestMapping("/edit/{id}")
    public String editCourt(@PathVariable("id") int id, Model model){
        model.addAttribute("court", this.courtService.findCourtById(id));
        model.addAttribute("listCourts", this.courtService.listCourts());
        return "court";
    }
	
}
