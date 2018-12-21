package tiralabra.okulfrekvenssi.Ciphers;

import tiralabra.okulfrekvenssi.Ciphers.Vigenere;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import tiralabra.okulfrekvenssi.util.Alphabet;

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
        Vigenere instance = new Vigenere(Alphabet.SUOMI);
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
        String message = "Testmessage";
        String passphrase = "test";
        Vigenere vig = new Vigenere(Alphabet.SUOMI);
        String expResult = "Jihjcihitkw";
        
        long start = System.nanoTime();
        String encrypted = vig.encrypt(message, passphrase);
        long end = System.nanoTime();
        assertEquals(expResult, encrypted);
        long start2 = System.nanoTime();
        String resultDecrypt = vig.decrypt(expResult, passphrase);
        long end2 = System.nanoTime();
        assertEquals(message, resultDecrypt);

        long min = Long.MAX_VALUE;
        long max = 0;
        int maxi = -1;
        int mini = -1;
        long sum = 0;
        long minDec = Long.MAX_VALUE;
        long maxDec = 0;
        int maxiDec = -1;
        int miniDec = -1;
        long sumDec = 0;
        for (int i = 0; i < 1000; i++) {
            start = System.nanoTime();
            encrypted = vig.encrypt("Testmessage", "test");
            end = System.nanoTime();
            sum += end - start;
            if (min > (end - start)) {
                min = end - start;
                mini=i;
            }
            if (max < (end - start)) {
                max = end - start;
                maxi=i;
            }
        }
        for (int i = 0; i < 1000; i++) {
            start = System.nanoTime();
            encrypted = vig.encrypt("Testmessage", "test");
            end = System.nanoTime();
            sumDec += end - start;
            if (min > (end - start)) {
                min = end - start;
                miniDec=i;
            }
            if (max < (end - start)) {
                max = end - start;
                maxiDec=i;
            }
        }
        System.out.println("avg encrypt time: "+(sum/1000)+", avg decrypt time: "+(sumDec/1000));
        System.out.println((end-start)+", "+(end2-start2));
        String message2 = "test bound.ary";
        String passphrase2 = "qwefgjnioxm";
        String encryptResult2 = vig.encrypt(message2, passphrase2);
        assertEquals("gåwy hxevr.xal", encryptResult2);
        assertEquals(message2, vig.decrypt(encryptResult2, passphrase2));
    }

}
