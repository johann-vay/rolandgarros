/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolandgarros.controller;

import fr.rolandgarros.dao.entities.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import fr.rolangarros.dao.service.CountryService;

@Controller
public class CountryController {
	
	private CountryService countryService;
	
	@Autowired(required=true)
	@Qualifier(value="countryService")
	public void setcountryService(CountryService cs){
		this.countryService = cs;
	}
	
	@RequestMapping(value = "/countries", method = RequestMethod.GET)
	public String listCountries(Model model) {
		model.addAttribute("country", new Country());
		model.addAttribute("listPersons", this.countryService.listCountries());
		return "person";
	}
	
	//For add and update person both
	@RequestMapping(value= "/country/add", method = RequestMethod.POST)
	public String addCountry(@ModelAttribute("country") Country c){
		
		if(c.getIdCountry() == 0){
			//new Country, add it
			this.countryService.addCountry(c);
		}else{
			//existing Country, call update
			this.countryService.updateCountry(c);
		}
		
		return "redirect:/countries"; //page jsp 
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removeCountry(@PathVariable("id") int id){
		
        this.countryService.removeCountry(id);
        return "redirect:/countries"; //page jsp 
    }
 
    @RequestMapping("/edit/{id}")
    public String editCountry(@PathVariable("id") int id, Model model){
        model.addAttribute("countries", this.countryService.findCountryById(id));
        model.addAttribute("listCountries", this.countryService.listCountries());
        return "country";
    }
	
}