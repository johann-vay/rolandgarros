/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolangarros.dao.service;

import fr.rolandgarros.dao.entities.Court;
import java.util.List;

/**
 *
 * @author Johann
 */
public interface CourtService {
    public Court addCourt(Court c);
    public Court updateCourt(Court c);
    public List<Court> listCourts();
    public Court findCourtById(int id);
    public boolean removeCourt(int id);
}
