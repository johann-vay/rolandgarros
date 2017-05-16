/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolangarros.dao.service;

import fr.rolandgarros.dao.entities.User;
import fr.rolandgarros.dao.dao.UserDao;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Johann
 */
public class UserServiceImp implements UserService{

    private UserDao userDao;
    
    public void getUserDao(){
        this.userDao = new UserDao();
    }
    
    @Override
    @Transactional
    public User addUser(User u) {
        return this.userDao.addUser(u);
    }

    @Override
    @Transactional
    public User updateUser(User u) {
        return this.userDao.updateUser(u);
    }

    @Override
    @Transactional
    public List<User> listUsers() {
        return this.userDao.findAll();
    }

    @Override
    @Transactional
    public User findUserById(int id) {
        return this.userDao.findUserById(id);
    }

    @Override
    @Transactional
    public boolean removeUser(int id) {
        return this.userDao.removeUser(id);
    }
    
}
