/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.shared;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author talend
 */
public class FieldVerifierTest {
    
    FieldVerifier fiel;
    
    public FieldVerifierTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        fiel = new FieldVerifier();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isValidName method, of class FieldVerifier.
     */
    //@Test
    /*public void testIsValidName() {
        System.out.println("isValidName");
        String name = "";
        boolean expResult = false;
        boolean result = FieldVerifier.isValidName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of isValidDecimal method, of class FieldVerifier.
     */
    //@Test
    /*public void testIsValidDecimal() {
        System.out.println("isValidDecimal");
        Integer nbr = null;
        boolean expResult = false;
        boolean result = FieldVerifier.isValidDecimal(nbr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of isValidRoman method, of class FieldVerifier.
     */
    @Test
    public void testIsValidRoman() {
        assertEquals(true, fiel.isValidRoman("M"));
        
        assertEquals(true, fiel.isValidRoman("MIII"));
        
        assertEquals(false, fiel.isValidRoman("A"));
        
        assertEquals(false, fiel.isValidRoman("MM"));
        
        assertEquals(false, fiel.isValidRoman("CCCC"));
        
        assertEquals(false, fiel.isValidRoman("VV"));

        assertEquals(false, fiel.isValidRoman("XXXX"));
        
        assertEquals(false, fiel.isValidRoman("LL"));
        
        assertEquals(true, fiel.isValidRoman("L"));
        
        assertEquals(false, fiel.isValidRoman(""));
    }

    /**
     * Test of isValidDate method, of class FieldVerifier.
     */
    //@Test
    /*public void testIsValidDate() {
        System.out.println("isValidDate");
        String date = "";
        boolean expResult = false;
        boolean result = FieldVerifier.isValidDate(date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
