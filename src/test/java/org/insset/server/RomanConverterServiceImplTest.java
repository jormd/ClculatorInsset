/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import org.insset.client.service.RomanConverterService;
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
public class RomanConverterServiceImplTest {
    
    RomanConverterServiceImpl romanConverter;
    
    public RomanConverterServiceImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.romanConverter = new RomanConverterServiceImpl();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of convertDateYears method, of class RomanConverterServiceImpl.
     */
    /*@Test
    public void testConvertDateYears() {
        System.out.println("convertDateYears");
        String nbr = "";
        RomanConverterServiceImpl instance = new RomanConverterServiceImpl();
        String expResult = "";
        String result = instance.convertDateYears(nbr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of convertRomanToArabe method, of class RomanConverterServiceImpl.
     */
    @Test
    public void testConvertRomanToArabe() {
        int res = this.romanConverter.convertRomanToArabe("M");
        
        assertEquals(1000, res);
        
        res = this.romanConverter.convertRomanToArabe("MII");
        
        assertEquals(1002, res);
        
        res = this.romanConverter.convertRomanToArabe("mii");
        
        assertEquals(1002, res);
        
        res = this.romanConverter.convertRomanToArabe("mcm");
        
        assertEquals(1900, res);
        
        res = this.romanConverter.convertRomanToArabe("MCDXCIX");
        
        assertEquals(1499, res);
        
        res = this.romanConverter.convertRomanToArabe("MD");
        
        assertEquals(1500, res);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testConvertRomanToArabeException(){
        int res = this.romanConverter.convertRomanToArabe("");
        
    }

    /**
     * Test of convertArabeToRoman method, of class RomanConverterServiceImpl.
     */
    /*@Test
    public void testConvertArabeToRoman() {
        System.out.println("convertArabeToRoman");
        Integer nbr = null;
        RomanConverterServiceImpl instance = new RomanConverterServiceImpl();
        String expResult = "";
        String result = instance.convertArabeToRoman(nbr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
