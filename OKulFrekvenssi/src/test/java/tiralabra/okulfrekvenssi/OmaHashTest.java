/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.okulfrekvenssi;

import tiralabra.okulfrekvenssi.util.OmaHash;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Oskari
 */
public class OmaHashTest {
    
    public OmaHashTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of hash method, of class OmaHash.
     */
    @Test
    public void testHash() {
        System.out.println("hash");
        Object key = null;
        int expResult = 0;
        int result = OmaHash.hash(key);
        assertEquals(expResult, result);
        expResult=5;
        key = 5;
        result = OmaHash.hash(key);
        assertEquals(expResult, result);
    }


    @Test
    public void testPutAndGet() {
        System.out.println("put");
        Object k = 'g';
        Object v = 255;
        OmaHash instance = new OmaHash();
        instance.put(k, v);
        Object expResult = 255;
        Object result = instance.get('g');
        assertEquals(expResult, result);
    }
    
}
