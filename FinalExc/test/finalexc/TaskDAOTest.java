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
 * @author s698926
 */
public class TaskDAOTest {
    
    public TaskDAOTest() {
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

    /*@Test
    public void testGetTasks() {
        TaskDAO instance = new TaskDAO();
        instance.addTask("2008-11-11", "2009-11-11", "töihommia", "missä lystääpi");
    }   
    @Test
    public void testAddStart() {
        TaskDAO instance = new TaskDAO();
        instance.addStart(7);
    } */  
    @Test
    public void testAddEnd() {
        TaskDAO instance = new TaskDAO();
        instance.addEnd(7);
    }
    @Test
    public void testAddId() {
        TaskDAO instance = new TaskDAO();
        instance.addId(1, 7);
    }
    
}
