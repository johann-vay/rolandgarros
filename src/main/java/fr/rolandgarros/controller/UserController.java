/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolandgarros.controller;

import fr.rolandgarros.dao.dao.IUserDao;
import fr.rolandgarros.dao.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import fr.rolangarros.dao.service.UserService;
import utils.Constants;

@Controller
public class UserController {
	
	private IUserDao userDao;
	
	@Autowired(required=true)
	@Qualifier(value="userService")
	public void setuserService(UserService cs){
		this.userDao = (IUserDao) Constants.ctx.getBean("userDao");
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String listUsers(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("listUsers", this.userDao.findAll(User.class));
		return "user";
	}
	
	//For add and update user both
	@RequestMapping(value= "/user/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User c){
		
		if(c.getIdUser() == 0){
			//new user, add it
			this.userDao.create(User.class);
		}else{
			//existing user, call update
			this.userDao.update(User.class);
		}
		
		return "redirect:/user"; //page jsp 
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") int id){
	User user = (User) userDao.findById(User.class, id);
        this.userDao.delete(user);
        return "redirect:/users"; //page jsp 
    }
 
    @RequestMapping("/edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userDao.findById(User.class,id));
        model.addAttribute("listUsers", this.userDao.findAll(User.class));
        return "user";
    }
	
}
