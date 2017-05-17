/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolandgarros.dao.dao;

/**
 *
 * @author etudiant
 */
import java.util.List;


public interface IGenericDao {

    Object create(Object obj);

    Object update(Object obj);

    boolean delete(Object obj);

    Object findById(Class myClass, Integer id);

    List findAll(Class myClass);
}