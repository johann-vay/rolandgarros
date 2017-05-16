/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolangarros.dao.service;

import fr.rolandgarros.dao.entities.Referee;
import java.util.List;

/**
 *
 * @author Johann
 */
public interface RefereeService {
    public Referee addReferee(Referee r);
    public Referee updateReferee(Referee r);
    public List<Referee> listReferees();
    public Referee findRefereeById(int id);
    public boolean removeReferee(int id);
}
