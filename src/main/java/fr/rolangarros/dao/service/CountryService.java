/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolangarros.dao.service;

import fr.rolandgarros.dao.entities.Country;
import java.util.List;

/**
 *
 * @author Johann
 */
public interface CountryService {
    
    public Country addCountry(Country c);
    public Country updateCountry(Country c);
    public List<Country> listCountries();
    public Country findCountryById(int id);
    public boolean removeCOuntry(int id);
}
