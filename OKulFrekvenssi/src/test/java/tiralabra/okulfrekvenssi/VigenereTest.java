package tiralabra.okulfrekvenssi;

import tiralabra.okulfrekvenssi.Ciphers.Vigenere;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class VigenereTest {

    public VigenereTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getKeytable method, of class Vigenere.
     */
    @Test
    public void testGetKeytable() {
        System.out.println("getKeytable");
        Vigenere instance = new Vigenere();
        char[][] expResult = new char[29][29];
        expResult[0] = "abcdefghijklmnopqrstuvwxyzåäö".toCharArray();
        expResult[1] = "bcdefghijklmnopqrstuvwxyzåäöa".toCharArray();
        expResult[2] = "cdefghijklmnopqrstuvwxyzåäöab".toCharArray();
        expResult[3] = "defghijklmnopqrstuvwxyzåäöabc".toCharArray();
        expResult[4] = "efghijklmnopqrstuvwxyzåäöabcd".toCharArray();
        expResult[5] = "fghijklmnopqrstuvwxyzåäöabcde".toCharArray();
        expResult[6] = "ghijklmnopqrstuvwxyzåäöabcdef".toCharArray();
        expResult[7] = "hijklmnopqrstuvwxyzåäöabcdefg".toCharArray();
        expResult[8] = "ijklmnopqrstuvwxyzåäöabcdefgh".toCharArray();
        expResult[9] = "jklmnopqrstuvwxyzåäöabcdefghi".toCharArray();
        expResult[10] = "klmnopqrstuvwxyzåäöabcdefghij".toCharArray();
        expResult[11] = "lmnopqrstuvwxyzåäöabcdefghijk".toCharArray();
        expResult[12] = "mnopqrstuvwxyzåäöabcdefghijkl".toCharArray();
        expResult[13] = "nopqrstuvwxyzåäöabcdefghijklm".toCharArray();
        expResult[14] = "opqrstuvwxyzåäöabcdefghijklmn".toCharArray();
        expResult[15] = "pqrstuvwxyzåäöabcdefghijklmno".toCharArray();
        expResult[16] = "qrstuvwxyzåäöabcdefghijklmnop".toCharArray();
        expResult[17] = "rstuvwxyzåäöabcdefghijklmnopq".toCharArray();
        expResult[18] = "stuvwxyzåäöabcdefghijklmnopqr".toCharArray();
        expResult[19] = "tuvwxyzåäöabcdefghijklmnopqrs".toCharArray();
        expResult[20] = "uvwxyzåäöabcdefghijklmnopqrst".toCharArray();
        expResult[21] = "vwxyzåäöabcdefghijklmnopqrstu".toCharArray();
        expResult[22] = "wxyzåäöabcdefghijklmnopqrstuv".toCharArray();
        expResult[23] = "xyzåäöabcdefghijklmnopqrstuvw".toCharArray();
        expResult[24] = "yzåäöabcdefghijklmnopqrstuvwx".toCharArray();
        expResult[25] = "zåäöabcdefghijklmnopqrstuvwxy".toCharArray();
        expResult[26] = "åäöabcdefghijklmnopqrstuvwxyz".toCharArray();
        expResult[27] = "äöabcdefghijklmnopqrstuvwxyzå".toCharArray();
        expResult[28] = "öabcdefghijklmnopqrstuvwxyzåä".toCharArray();
        char[][] result = instance.getKeytable();
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testEncrypt() {
        System.out.println("encrypt");
        String message = "testmessage";
        String passphrase = "test";
        Vigenere instance = new Vigenere();
        String expResult = "jihjcihitkw";
        long start = System.nanoTime();
        String result = instance.encrypt(message, passphrase);
        long end = System.nanoTime();
        assertEquals(expResult, result);
        long start2 = System.nanoTime();
        String resultDecrypt = instance.decrypt(expResult, passphrase);
        long end2 = System.nanoTime();
        assertEquals(message, resultDecrypt);

        System.out.println((end-start)+", "+(end2-start2));
        String message2 = "testboundary";
        String passphrase2 = "qwefgjnioxm";
        String encryptResult2 = instance.encrypt(message2, passphrase2);
        assertEquals("gåwyhxevrxal", encryptResult2);
        assertEquals(message2, instance.decrypt(encryptResult2, passphrase2));
    }

}
