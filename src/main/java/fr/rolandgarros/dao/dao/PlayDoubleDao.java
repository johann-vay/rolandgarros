/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolandgarros.dao.dao;

import org.hibernate.Session;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author etudiant
 */
public class PlayDoubleDao extends GenericDao implements IPlayDoubleDao {

    private SessionFactory sessionFactory;
    public PlayDoubleDao() {
    }

    /*@Override
    public boolean delete(int idTeam, int idGame) {
        Session session = this.sessionFactory.getCurrentSession();
        Object obj = session.load(Object.class, new Integer(idTeam), new Integer(idGame));
        if (null != obj) {
            session.delete(obj);
        }
        return true;
    }*/

}
