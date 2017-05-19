/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolandgarros.controller;

import fr.rolandgarros.dao.dao.ICourtDao;
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
import utils.Constants;

@Controller
public class CourtController {
	
	private ICourtDao courtDao;
	
	@Autowired(required=true)
	@Qualifier(value="courtService")
	public void setcourtService(CourtService cs){
		this.courtDao = (ICourtDao) Constants.ctx.getBean("courtDao");
	}
	
	@RequestMapping(value = "/courts", method = RequestMethod.GET)
	public String listCourts(Model model) {
		model.addAttribute("court", new Court());
		model.addAttribute("listCourts", this.courtDao.findAll(Court.class));
		return "court";
	}
	
	//For add and update court both
	@RequestMapping(value= "/court/add", method = RequestMethod.POST)
	public String addCourt(@ModelAttribute("court") Court c){
		
		if(c.getIdCourt() == 0){
			//new court, add it
			this.courtDao.create(Court.class);
		}else{
			//existing court, call update
			this.courtDao.update(Court.class);
		}
		
		return "redirect:/court"; //page jsp 
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removeCourt(@PathVariable("id") int id){
	Court court = (Court) courtDao.findById(Court.class, id);
        this.courtDao.delete(court);
        return "redirect:/courts"; //page jsp 
    }
 
    @RequestMapping("/edit/{id}")
    public String editCourt(@PathVariable("id") int id, Model model){
        model.addAttribute("court", this.courtDao.findById(Court.class,id));
        model.addAttribute("listCourts", this.courtDao.findAll(Court.class));
        return "court";
    }
	
}
