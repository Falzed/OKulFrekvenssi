/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.okulfrekvenssi.Ciphers;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import tiralabra.okulfrekvenssi.Ciphers.KeyedCaesar;

/**
 *
 * @author Oskari
 */
public class KeyedCaesarTest {
    
    private KeyedCaesar kcaesar = new KeyedCaesar("avain");
    
    @Test
    public void testEncryptCaesar() {
        String encrypted = kcaesar.encrypt("abcdefghij", 0);
        assertEquals("avinbcdefg", encrypted);
        encrypted = kcaesar.encrypt("testmessage", 5);
        assertEquals("ygxyqgxxcjg", encrypted);
    }
    
    @Test
    public void testDecryptCaesar() {
        String decrypted = kcaesar.decrypt("avinbcdefg", 0);
        assertEquals("abcdefghij", decrypted);
        decrypted = kcaesar.decrypt("ygxyqgxxcjg", 5);
        assertEquals("testmessage", decrypted);
    }
}
