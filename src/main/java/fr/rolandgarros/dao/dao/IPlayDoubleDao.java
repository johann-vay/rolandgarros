/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolandgarros.dao.dao;

import java.util.List;

/**
 *
 * @author etudiant
 */
public interface IPlayDoubleDao extends IGenericDao{
    
    @Override
    Object create(Object obj);

    @Override
    Object update(Object obj);

    @Override
    boolean delete(Object obj);

    @Override
    Object findById(Class myClass, int id);

    @Override
    List findAll(Class myClass);
    
    //public boolean delete(int idTeam, int idGame);
}
