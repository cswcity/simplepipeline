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
import org.junit.Ignore;

/**
 *
 * @author charlie
 */
public class UploadBeanTest {
    private String input;
    
    public UploadBeanTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        input = ">SRR099334\nGT\n" +
        ">SRR099335\nGTG";

    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getSequences method, of class UploadBean.
     */
    @Test
    @Ignore
    public void testGetSequences() {
        System.out.println("getSequences");
        UploadBean instance = new UploadBean();
        instance.setTesting(true);
        instance.setInput(input);
        HashMap<String, DNASequence> expResult = new HashMap<>();
        expResult.put("SRR099334", 
                new DNASequence("GT"));
        expResult.put("SRR099335", 
                new DNASequence("GTG"));
        HashMap<String, DNASequence> result = instance.getSequences();
            
        assertEquals(expResult, result);

    }

    /**
     * Test of getCount method, of class UploadBean.
     */
    @Test
    public void testGetCount() {
        System.out.println("getCount");
        UploadBean instance = new UploadBean();
        instance.setTesting(true);
        instance.setInput(input);
        int expResult = 2;
        int result = instance.getCount();
        assertEquals(expResult, result);

    }

    /**
     * Test of getInput method, of class UploadBean.
     */
    @Test
    public void testGetInput() {
        System.out.println("getInput");
        UploadBean instance = new UploadBean();
        instance.setTesting(true);
        instance.setInput(input);
        String expResult = input;
        String result = instance.getInput();
        assertEquals(expResult, result);

    }
 
}
