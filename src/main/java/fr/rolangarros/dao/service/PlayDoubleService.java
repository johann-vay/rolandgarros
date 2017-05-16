/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolangarros.dao.service;

import fr.rolandgarros.dao.entities.Playdouble;
import java.util.List;

/**
 *
 * @author Johann
 */
public interface PlayDoubleService {
    public Playdouble addPlaydouble(Playdouble p);
    public Playdouble updatePlaydouble(Playdouble p);
    public List<Playdouble> listPlaydouble();
    public Playdouble findPlaydouble(int idTeam, int idGame);
    public boolean removePlaydouble(int idTeam, int idGame);
}
