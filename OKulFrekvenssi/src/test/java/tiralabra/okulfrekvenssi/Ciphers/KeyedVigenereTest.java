/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.okulfrekvenssi.Ciphers;

import java.util.Arrays;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Oskari
 */
public class KeyedVigenereTest {
    
    public KeyedVigenereTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getKeytable method, of class KeyedVigenere.
     */
    @Test
    public void testGetKeytable() {
        System.out.println("getKeytable");
        KeyedVigenere instance = new KeyedVigenere("key");
        char[][] expResult = new char[29][29];
        String abc = "keyabcdfghijlmnopqrstuvwxzåäö";
        for(int i=0; i<29; i++) {
            expResult[i]=abc.substring(i).concat(abc.substring(0, i)).toCharArray();
        }
        char[][] result = instance.getKeytable();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of encrypt method, of class KeyedVigenere.
     */
    @Test
    public void testEncrypt() {
              
        System.out.println("encrypt");
        String message = "books";
        String passphrase = "auto";
        KeyedVigenere instance = new KeyedVigenere("key");
        
        for(char[] array:instance.getKeytable()) {
            System.out.println(new String(array));
        }
        
        String expResult = "ffdov";
        String result = instance.encrypt(message, passphrase);
        assertEquals(expResult, result);
    }

    /**
     * Test of decrypt method, of class KeyedVigenere.
     */
    @Test
    public void testDecrypt() {
        System.out.println("decrypt");
        String crypted = "ffdov";
        String passphrase = "auto";
        KeyedVigenere instance = new KeyedVigenere("key");
        String expResult = "books";
        String result = instance.decrypt(crypted, passphrase);
        assertEquals(expResult, result);
    }
    
}
