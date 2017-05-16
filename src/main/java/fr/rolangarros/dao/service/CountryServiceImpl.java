/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolangarros.dao.service;

import fr.rolandgarros.dao.entities.Country;
import fr.rolandgarros.dao.dao.CountryDao;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Johann
 */

@Service
public class CountryServiceImpl implements CountryService {

    private CountryDao countryDao;
    
    public void getCountryDao(){
        this.countryDao = new CountryDao();
    }
    
    
    @Override
    @Transactional
    public Country addCountry(Country c) {
        return this.countryDao.addCountry(c);
    }

    @Override
    @Transactional
    public Country updateCountry(Country c) {
        return this.countryDao.updateCountry(c);
    }

    @Override
    @Transactional
    public List<Country> listCountries() {
        return this.countryDao.findall();
    }

    @Override
    @Transactional
    public Country findCountryById(int id) {
        return this.countryDao.findCountryById(id);
    }

    @Override
    @Transactional
    public boolean removeCountry(int id) {
        return this.countryDao.removeCountry(id);
    }
    
}
