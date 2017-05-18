package fr.rolandgarros.dao.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ElHadji
 */

@Transactional
public abstract class GenericDao implements IGenericDao {

    @PersistenceContext
    private EntityManager em;
    

    @Override
    public Object create(Object obj) {
        System.out.print(obj);
        em.persist(obj);
        return obj;
    }

    @Override
    public Object update(Object obj) {
        em.merge(obj);
        return obj;
    }

    @Override
    public boolean delete(Object obj) {
        if (null != obj) {
            em.remove(em.merge(obj));
        }
        return true;
    }

    @Override
    public Object findById(Class myClass, int id) {
        return em.find(myClass, id);
    }

    @Override
    public List findAll(Class myClass) {
        List<Object> list = null;
        String namedQuery = myClass.getSimpleName()+".findAll";
        list = em.createNamedQuery(namedQuery).getResultList();
        return list;
    }

    /* public List findByCriteria(Class myClass, String namedQuery, Map<String, Object> parameters) {
     List entities = null; //instanciation null de la liste à renvoyer en fin de fonction
     String methodName = namedQuery;

     if (namedQuery != null && parameters != null && !parameters.isEmpty()) { //si le nom de la requete (défini dans la classe personne en String) non null etc...
     if (em != null) { // si em non null
     Query queryParams = em.createNamedQuery(myClass.getSimpleName() + "." + namedQuery); //
     for (Map.Entry<String, Object> entry : parameters.entrySet()) { //
     String key = entry.getKey();
     Object value = entry.getValue();
     queryParams.setParameter(key, value);
     }
     entities = queryParams.getResultList();
     closeEntityManager(em);
     }
     }
        

     return entities;
     }*/
}
