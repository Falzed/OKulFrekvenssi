/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.okulfrekvenssi.Ciphers;

import tiralabra.okulfrekvenssi.Ciphers.Caesar;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import tiralabra.okulfrekvenssi.util.Alphabet;

/**
 *
 * @author Oskari
 */
public class CaesarTest {

//    private Caesar caesar;
    public CaesarTest() {
    }

//    @Before
//    public void setUp() {
//        caesar = new Caesar();
//    }
    @After
    public void tearDown() {
    }

    @Test
    public void testEncrypt() {
        Caesar caesar = new Caesar();
        long sum = 0;
        long start = System.nanoTime();
        String encrypted = caesar.encrypt("Yjxyrjxxflj", 5, Alphabet.SUOMI);
        long end = System.nanoTime();
        System.out.println("Ensimmäinen enkryptaus: " + (end - start) + " ns");
        long min = Long.MAX_VALUE;
        long max = 0;
        int maxi = -1;
        int mini = -1;
        for (int i = 0; i < 1000; i++) {
            start = System.nanoTime();
            encrypted = caesar.encrypt("Testmessage", 5, Alphabet.SUOMI);
            end = System.nanoTime();
            sum += end - start;
            if (min > (end - start)) {
                min = end - start;
                mini = i;
            }
            if (max < (end - start)) {
                max = end - start;
                maxi = i;
            }
        }

        System.out.println("aika \"Testmessage\"-viestin salaukseen keskimäärin: "
                + (sum) / 1000 + " ns");
        assertEquals(encrypted, "Yjxyrjxxflj");
    }
//
//    @Test
//    public void testEncryptMillion() {
//        Caesar caesar = new Caesar();
//        long sum = 0;
//        long start = System.nanoTime();
//        String encrypted = caesar.encrypt("Yjxyrjxxflj", 5, Alphabet.SUOMI);
//        long end = System.nanoTime();
//        System.out.println("Ensimmäinen enkryptaus: " + (end - start) + " ns");
//        String message = "";
//        for (int j = 1; j < 21; j++) {
//            sum = 0;
//            message=message.concat("testmessage");
//            for (int i = 0; i < 1000000; i++) {
//                start = System.nanoTime();
//                encrypted = caesar.encrypt(message, 5, Alphabet.SUOMI);
//                end = System.nanoTime();
//                sum += end - start;
//            }
//            if (j != 20) {
//                System.out.print(sum / 1000000 + ",");
//            } else {
//                System.out.println(sum / 1000000);
//            }
//        }
//        System.out.println("aika \"Testmessage\"-viestin salaukseen keskimäärin: "
//                + (sum) / 1000000 + " ns");
//    }

    @Test
    public void testDecrypt() {
        Caesar caesar = new Caesar();
        long sum = 0;
        long start = System.nanoTime();
        String decrypted = caesar.decrypt("Yjxyrjxxflj", 5, Alphabet.SUOMI);
        long end = System.nanoTime();
        System.out.println("Ensimmäinen dekryptaus: " + (end - start) + " ns");
        long min = Long.MAX_VALUE;
        long max = 0;
        int maxi = -1;
        int mini = -1;
        for (int i = 0; i < 1000; i++) {
            start = System.nanoTime();
            decrypted = caesar.decrypt("Yjxyrjxxflj", 5, Alphabet.SUOMI);
            end = System.nanoTime();
            sum += end - start;
            if (min > (end - start)) {
                min = end - start;
                mini = i;
            }
            if (max < (end - start)) {
                max = end - start;
                maxi = i;
            }
        }
//        long start = System.nanoTime();
//        String decrypted = caesar.decrypt("Yjxyrjxxflj", 5);
//        long end = System.nanoTime();
//        System.out.println("aika \"Yjxyrjxxflj\"-viestin dekryptaukseen: "
//                + (end - start) + " ns");
        System.out.println("Keskiarvoinen dekryptaus aika (\"Yjxyrjxxflj\", n=1000) : " + sum / 1000 + " ns");
        System.out.println("max: " + max + " ns (i=" + maxi + "), min: " + min + " ns (i=" + mini + ")");
        assertEquals(decrypted, "Testmessage");
    }

//    @Test
//    public void testDecryptMillion() {
//        Caesar caesar = new Caesar();
//        long sum = 0;
//        long start = System.nanoTime();
//        String decrypted = caesar.decrypt("Yjxyrjxxflj", 5, Alphabet.SUOMI);
//        long end = System.nanoTime();
//        System.out.println("Ensimmäinen dekryptaus: " + (end - start) + " ns");
//        String crypted = "";
//        for (int j = 1; j < 21; j++) {
//            sum = 0;
//            crypted = crypted.concat("Yjxyrjxxflj");
//            
//            for (int i = 0; i < 1000000; i++) {
//                start = System.nanoTime();
//                decrypted = caesar.decrypt("Yjxyrjxxflj", 5, Alphabet.SUOMI);
//                end = System.nanoTime();
//                sum += end - start;
//            }
////            System.out.println("Keskiarvoinen dekryptaus aika (\"Yjxyrjxxflj\"*"+j+", n=1000000"+") : " + sum / 1000000 + " ns");
//            if (j != 20) {
//                System.out.print(sum / 1000000 + ",");
//            } else {
//                System.out.println(sum / 1000000);
//            }
//        }
//
//    }

}
