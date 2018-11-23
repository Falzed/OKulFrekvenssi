/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.okulfrekvenssi;

import tiralabra.okulfrekvenssi.Ciphers.Caesar;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Oskari
 */
public class CaesarTest {
    
    private Caesar caesar;
    
    public CaesarTest() {
    }
    
    @Before
    public void setUp() {
        caesar = new Caesar();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testEncrypt() {
        long start = System.nanoTime();
        String encrypted = caesar.encrypt("testmessage", 5);
        long end = System.nanoTime();
        System.out.println("aika \"testmessage\"-viestin salaukseen: "+
                (end-start)+" ns");
        assertEquals(encrypted, "yjxyrjxxflj");
    }
    
    @Test
    public void testDecrypt() {
        long start = System.nanoTime();
        String decrypted = caesar.decrypt("yjxyrjxxflj", 5);
        long end = System.nanoTime();
        System.out.println("aika \"yjxyrjxxflj\"-viestin dekryptaukseen: "+
                (end-start)+" ns");
        assertEquals(decrypted, "testmessage");
    }
    
}
