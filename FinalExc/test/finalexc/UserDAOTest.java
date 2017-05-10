/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalexc;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author s303004
 */
public class UserDAOTest {
    
    public UserDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
   /* @Test
    public void addUsers() {
        UserDAO instance = new UserDAO();
        instance.addUser("Testi", "testipassu", "testi kuvaus!!");
        ProjectManagementController pmc = new ProjectManagementController();
        assertEquals([]"testipassu testi",pmc.getUser("Testi", "testipassu");
        //assertEquals([Fail] "Testi", "gf");
        */
    }
    @Test
    public void getUsers() {
        UserDAO instance = new UserDAO();
        instance.getUsers();
    }
        public void getUser() {
        UserDAO instance = new UserDAO();
        instance.getUser("Testi", "testipassu");
    }
        @Test
    public void deleteUsers() {
        UserDAO instance = new UserDAO();
        instance.deleteUser("Testi");
    }
            @Test
    public void getWithNameAndPassword() {
        UserDAO instance = new UserDAO();
        instance.getWithNameAndPassword("Testi", "testipassu");
    }
    
    
}
