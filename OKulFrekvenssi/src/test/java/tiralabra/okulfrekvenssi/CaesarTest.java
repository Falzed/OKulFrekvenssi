/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.okulfrekvenssi;

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
        String encrypted = caesar.encrypt("testmessage", 5);
        assertEquals(encrypted, "yjxyrjxxflj");
    }
    
    @Test
    public void testDecrypt() {
        String decrypted = caesar.decrypt("yjxyrjxxflj", 5);
        assertEquals(decrypted, "testmessage");
    }
    
}
