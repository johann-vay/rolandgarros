/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolandgarros.controller;

import fr.rolandgarros.dao.dao.ICountryDao;
import fr.rolandgarros.dao.entities.Country;
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
public class CountryController {
	
	private ICountryDao countryDao;
	
	@Autowired(required=true)
	@Qualifier(value="countryService")
	public void setcountryService(){
		this.countryDao = (ICountryDao) Constants.ctx.getBean("countryDao");
	}
	
	@RequestMapping(value = "/countries", method = RequestMethod.GET)
	public String listCountries(Model model) {
		model.addAttribute("listCountries", this.countryDao.findAll(Country.class));
		return "country";
	}
	
	//For add and update country both
	@RequestMapping(value= "/country/add", method = RequestMethod.POST)
	public String addCountry(@ModelAttribute("country") Country c){
		
		if(c.getIdCountry() == 0){
			//new Country, add it
			this.countryDao.create(Country.class);
		}else{
			//existing Country, call update
			this.countryDao.update(Country.class);
		}
		
		return "redirect:/countries"; //page jsp 
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removeCountry(@PathVariable("id") int id){
	Country country = (Country) this.countryDao.findById(Country.class, id);
        this.countryDao.delete(country);
        return "redirect:/countries"; //page jsp 
    }
 
    @RequestMapping("/edit/{id}")
    public String editCountry(@PathVariable("id") int id, Model model){
        model.addAttribute("countries", this.countryDao.findById(Country.class, id));
        model.addAttribute("listCountries", this.countryDao.findAll(Country.class));
        return "country";
    }
	
}