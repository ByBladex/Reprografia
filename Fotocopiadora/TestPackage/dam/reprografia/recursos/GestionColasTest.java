/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam.reprografia.recursos;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author josel
 */
public class GestionColasTest {
    
    public GestionColasTest() {
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

    /**
     * Test of fotocopiar method, of class GestionColas.
     * @throws java.lang.InterruptedException
     */
    @Test
    public void testFotocopiar() throws InterruptedException {
        GestionColas instance = new GestionColas();
        int real = instance.fotocopiar();
        int esperado = 1;
        assertEquals(esperado, real);
    } 
}
