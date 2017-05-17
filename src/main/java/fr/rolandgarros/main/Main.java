/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolandgarros.main;

import fr.rolandgarros.dao.dao.CountryDao;
import fr.rolandgarros.dao.dao.ICountryDao;
import fr.rolandgarros.dao.entities.Country;
import fr.rolangarros.dao.service.CountryServiceImpl;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Johann
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("file:src/main/java/spring-dao-config.xml");
        CountryServiceImpl countryService = new CountryServiceImpl();
        CountryDao countryDao = countryService.getCountryDao();
        List<Country> countries = countryDao.findAll(Country.class);
        Country country = new Country("Test label");
        country = (Country) countryDao.create(country);
        System.out.print(countries);
        System.out.println(country);
        
        //testSpringHibernate();
    }
    public static void testSpringHibernate() {
        String methodName = "testSpringHibernate";
        boolean isDeleteOk = false;
        ApplicationContext ctx = new ClassPathXmlApplicationContext("file:src/main/java/spring-dao-config.xml");
        ICountryDao countryDao = (ICountryDao) ctx.getBean("countryDao");
        Country countryCRUD = new Country("Test label");
        System.out.println(countryCRUD);
        countryCRUD = (Country) countryDao.create(countryCRUD);
        System.out.println(countryCRUD);
        countryCRUD.setLabel("label update");
        System.out.println(countryCRUD);
        countryCRUD = (Country) countryDao.update(countryCRUD);
        System.out.println(countryCRUD);
        isDeleteOk = countryDao.delete(countryCRUD);
        System.out.println(methodName + " , personnes : " + countryDao.findAll(Country.class) + " , isDeleteOk : "+ isDeleteOk);
    }
}
