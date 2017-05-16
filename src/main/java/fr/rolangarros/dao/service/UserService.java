/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolangarros.dao.service;

import fr.rolandgarros.dao.entities.User;
import java.util.List;

/**
 *
 * @author Johann
 */
public interface UserService {
    public User addUser(User u);
    public User updateUser(User u);
    public List<User> listUsers();
    public User findUserById(int id);
    public boolean removeUser(int id);
}
