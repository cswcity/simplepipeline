/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.co.waterdancer.simplepipeline;

import java.util.HashMap;
import org.biojava3.core.sequence.DNASequence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author charlie
 */
public class MIDAlignBeanTest {
    
    public MIDAlignBeanTest() {
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
     * Test of getSeqs method, of class MIDAlignBean.
     */
    @Test
    public void testGetSeqs() {
        System.out.println("getSeqs");
        MIDAlignBean instance = new MIDAlignBean();
        HashMap<String, DNASequence> expResult = null;
        HashMap<String, DNASequence> result = instance.getSeqs();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of populate method, of class MIDAlignBean.
     */
    @Test
    public void testPopulate() {
        System.out.println("populate");
        String fasta = "";
        MIDAlignBean instance = new MIDAlignBean();
        instance.populate(fasta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
