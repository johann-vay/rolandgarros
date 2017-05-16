/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolangarros.dao.service;


import fr.rolandgarros.dao.entities.Game;
import java.util.List;

/**
 *
 * @author Johann
 */
public interface GameService {
    public Game addGame(Game g);
    public Game updateGame(Game g);
    public List<Game> listGames();
    public Game findGameById(int id);
    public boolean removeGame(int id);  
}
