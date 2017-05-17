/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rolandgarros.dao.test;

import com.ibatis.common.jdbc.ScriptRunner;
import fr.rolandgarros.dao.dao.PlayerDao;
import fr.rolandgarros.dao.entities.Player;
import fr.rolangarros.dao.service.PlayerServiceImpl;
import utils.Constants;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Johann
 */
public class JUnitPlayerDao {
    
    public static String className = JUnitPlayerDao.class.getName();
    
    // Compter le nombre de produit dans votre base de données rolandgarros
    private static final int NB_PLAYERS_LIST = 40;
    private static final int NB_PERSONNES_FIND_BY_ID = 1;

    private static List<Player> players = null;

    @BeforeClass
    public static void init() throws Exception {
        // configuration de l'application
        String methodName = "init";
        System.out.println("======================= " + className + " --> " + methodName + " ==========================");
        initDataBase();
        PlayerServiceImpl playerService = new PlayerServiceImpl();
        PlayerDao playerDao = playerService.getPlayerDao();
        players = playerDao.findAll(Player.class);
    }

    @BeforeClass
    public static void initDataBase() {
        // Initialiser les données de la base de données
        String methodName = "initDataBase";
        System.out.println("======================= " + className + " --> " + methodName + " ==========================");
        String scriptSqlPath = Constants.SQL_PATH_FILE;
        Reader reader = null;
        Connection connection = null;
        try {
            // Creer une connexion a la base de données.
            Class.forName(Constants.JDBC_DRIVER);
            connection = DriverManager.getConnection(
                    Constants.DATABASE_URL, Constants.DATABASE_USER, Constants.DATABASE_PASSWORD);
            // Initialiser l'objet ScripRunner
            ScriptRunner scriptRunner = new ScriptRunner(connection, false, false);
            // Ouvrir le fichier
            reader = new BufferedReader(
                    new FileReader(scriptSqlPath));
            // Executer le script Sql
            scriptRunner.runScript(reader);
        } catch (Exception e) {
            System.out.println("Erreur lors de l'execution du script : " + scriptSqlPath + "  dans la methodName " + methodName + ", Exception : " + e);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }

            } catch (IOException io) {
                System.out.println("Erreur lors de la fermiture d'un fichier dans la methode " + methodName + " , Exception : " + io.getMessage());
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlEx) {
                System.out.println("Erreur lors de la fermiture de la connexion dans la methode " + methodName + " , Exception : " + sqlEx.getMessage());
            }
        }
    }

    @Test
    public void testFindAllPersonnes() {
        String methodName = "testFindAllPersonnes";
        System.out.println("======================= " + className + " --> " + methodName + " ==========================");
        if (players != null) {
            System.out.println(className + " --> " + methodName + " , NB_PLAYERS_LIST: " + NB_PLAYERS_LIST + " , personnes.size(): " + players.size());
            Assert.assertEquals(NB_PLAYERS_LIST, players.size());
        }
    }

    /*@Test
    public void testFindByCriteria() {
        final String methodName = "testFindByCriteria";
        System.out.println("======================= " + className + " --> " + methodName + " ==========================");
        List<Personne> personnesByPrenom = metierServiceFacade.getPersonneDao().findPersonnesByPrenom("Julien");
        List<Personne> personnesByNom = metierServiceFacade.getPersonneDao().findPersonnesByNom("Dupond");
        List<Personne> personnesByPrenomNom = metierServiceFacade.getPersonneDao().findPersonnesByPrenomNom("Eric", "Dummat");
        List<Personne> personnesByPoids = metierServiceFacade.getPersonneDao().findPersonnesByPoids(100);
        List<Personne> personnesByRue = metierServiceFacade.getPersonneDao().findPersonnesByRue("rue de Paris");
        List<Personne> personnesByVille = metierServiceFacade.getPersonneDao().findPersonnesByVille("Paris");
        List<Personne> personnesByCodePostal = metierServiceFacade.getPersonneDao().findPersonnesByCodePostal("75000");
        List<Personne> personnesByPays = metierServiceFacade.getPersonneDao().findPersonnesByPays("France");
        List<Personne> personnesByPoidsInf = metierServiceFacade.getPersonneDao().findPersonnesByPoidsInf(101.0);
        List<Personne> personnesByPoidsInfSup = metierServiceFacade.getPersonneDao().findPersonnesByPoidsInfSup(80.0, 100.0);
        List<Personne> personnesByPoidsSup = metierServiceFacade.getPersonneDao().findPersonnesByPoidsSup(95.0);

        if (personnesByPrenom != null) {
            Assert.assertEquals(NB_PERSONNES_FIND_BY_PRENOM, personnesByPrenom.size());
        }
        if (personnesByNom != null) {
            Assert.assertEquals(NB_PERSONNES_FIND_BY_NOM, personnesByNom.size());
        }
        if (personnesByPrenomNom != null) {
            Assert.assertEquals(NB_PERSONNES_FIND_BY_PRENOM_NOM, personnesByPrenomNom.size());
        }
        if (personnesByPoids != null) {
            Assert.assertEquals(NB_PERSONNES_FIND_BY_POIDS, personnesByPoids.size());
        }
        if (personnesByRue != null) {
            Assert.assertEquals(NB_PERSONNES_FIND_BY_RUE, personnesByRue.size());
        }
        if (personnesByVille != null) {
            Assert.assertEquals(NB_PERSONNES_FIND_BY_VILLE, personnesByVille.size());
        }
        if (personnesByCodePostal != null) {
            Assert.assertEquals(NB_PERSONNES_FIND_BY_CODE_POSTAL, personnesByCodePostal.size());
        }
        if (personnesByPays != null) {
            Assert.assertEquals(NB_PERSONNES_FIND_BY_PAYS, personnesByPays.size());
        }
        if (personnesByPoidsInf != null) {
            Assert.assertEquals(NB_PERSONNES_FIND_BY_POIDS_INF, personnesByPoidsInf.size());
        }
        if (personnesByPoidsSup != null) {
            Assert.assertEquals(NB_PERSONNES_FIND_BY_POIDS_SUP, personnesByPoidsSup.size());
        }
        if (personnesByPoidsInfSup != null) {
            Assert.assertEquals(NB_PERSONNES_FIND_BY_POIDS_INF_SUP, personnesByPoidsInfSup.size());
        }
    }*/

    /*@Test
    public void testCreateUpdateDelete() {
        final String methodName = "testCreateUpdateDelete";
        System.out.println("======================= " + className + " --> " + methodName + " ==========================");
        Player personneCRUD = new Player("Barro", "Ass", );
        personneCRUD = (Personne) metierServiceFacade.getPersonneDao().create(personneCRUD);
        NB_PERSONNES_LIST++;
        Assert.assertNotNull(personneCRUD);
        System.out.println("Created personneCRUD : " + personneCRUD);
        personneCRUD = (Personne) metierServiceFacade.getPersonneDao().findById(Personne.class, personneCRUD.getIdPersonne());
        Assert.assertNotNull(personneCRUD);
        personneCRUD.setPrenom("Barro Bis");
        personneCRUD.setNom("Ass Bis");
        Assert.assertNotNull(metierServiceFacade.getPersonneDao().update(personneCRUD));
        personneCRUD = (Personne) metierServiceFacade.getPersonneDao().findById(Personne.class, personneCRUD.getIdPersonne());
        System.out.println("Updated personneCRUD : " + personneCRUD);
        Assert.assertEquals("Barro Bis", personneCRUD.getPrenom());
        Assert.assertEquals("Ass Bis", personneCRUD.getNom());
        Assert.assertTrue(metierServiceFacade.getPersonneDao().delete(personneCRUD));
        NB_PERSONNES_LIST--;
        List<Personne> personnesTest = metierServiceFacade.getPersonneDao().findAll(Personne.class);
        if (personnesTest != null) {
            Assert.assertEquals(personnesTest.size(), NB_PERSONNES_LIST);
            System.out.println("personnesTest.size() : " + personnesTest.size() + " , NB_PERSONNES_LIST: " + NB_PERSONNES_LIST);
        }
    }

    @AfterClass
    public static void terminate() throws Exception {
        String methodName = "terminate";
        System.out.println("======================= " + className + " --> " + methodName + " ==========================");
    }*/
}
