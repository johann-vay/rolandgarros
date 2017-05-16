package fr.rolandgarros.dao.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




/**
 *
 * @author ElHadji
 */
public abstract class GenericDao implements IGenericDao {
    
    private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
        
private static final Logger logger = LoggerFactory.getLogger(GenericDao.class);

    @Override
    public Object create(Object obj) {
 
        Session session = this.sessionFactory.getCurrentSession();
		session.persist(obj);
		logger.info("Person saved successfully, Person Details="+obj);
	
        return obj;
    }

    @Override
    public Object update(Object obj) {
        Session session = this.sessionFactory.getCurrentSession();
	session.update(obj);
	logger.info("Person updated successfully, Person Details="+obj);
        return obj;
    }


    @Override
    public boolean delete(int id) {
        Session session = this.sessionFactory.getCurrentSession();
	Object obj =  session.load(Object.class, new Integer(id));
	if(null != obj){
		session.delete(obj);
		}
	logger.info("Person deleted successfully, person details="+obj);
        return true;
    }

    

    @Override
    public Object findById(Class myClass, Integer id) {
       Session session = this.sessionFactory.getCurrentSession();
       Object obj = null; 
		 obj = session.load(myClass.getSimpleName(), new Integer(id));
		logger.info("Person loaded successfully, Person details="+obj);
		return obj;
    }


    @Override
    public List findAll(Class myClass) {
       Session session = this.sessionFactory.getCurrentSession();
		List<Object> list = session.createQuery("from Person").list();
		for(Object obj : list){
			logger.info("Person List::"+obj);
		}
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
