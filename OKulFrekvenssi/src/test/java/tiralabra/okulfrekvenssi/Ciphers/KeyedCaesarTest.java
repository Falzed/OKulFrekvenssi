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
        String encrypted = kcaesar.encrypt("abcdefghij", 5);
        assertEquals("cdefghjklm", encrypted);
        encrypted = kcaesar.encrypt("testmessage", 5);

        long start = System.nanoTime();
        encrypted = kcaesar.encrypt("testmessage", 5);
        long end = System.nanoTime();

        long min = Long.MAX_VALUE;
        long max = 0;
        int maxi = -1;
        int mini = -1;
        long sum = 0;
        for (int i = 0; i < 1000; i++) {
            start = System.nanoTime();
            encrypted = kcaesar.encrypt("Testmessage", 5);
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
        System.out.println("avg encrypt time: " + (sum / 1000));
        encrypted = kcaesar.encrypt("testmessage", 5);
        assertEquals("ygxyqgxxcjg", encrypted);
    }

    @Test
    public void testDecryptCaesar() {
        String decrypted = kcaesar.decrypt("cdefghjklm", 5);
        assertEquals("abcdefghij", decrypted);

        long start = System.nanoTime();
        decrypted = kcaesar.decrypt("avinbcdefg", 5);
        long end = System.nanoTime();
        long start2 = System.nanoTime();
        String resultDecrypt = kcaesar.decrypt("ygxyqgxxcjg", 5);
        long end2 = System.nanoTime();

        long min = Long.MAX_VALUE;
        long max = 0;
        int maxi = -1;
        int mini = -1;
        long sum = 0;
        for (int i = 0; i < 1000; i++) {
            start = System.nanoTime();
            decrypted = kcaesar.decrypt("avinbcdefg", 5);
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
        System.out.println("avg decrypt time: " + (sum / 1000));
        System.out.println((end - start) + ", " + (end2 - start2));

        decrypted = kcaesar.decrypt("ygxyqgxxcjg", 5);

        assertEquals("testmessage", decrypted);
    }

//    @Test
//    public void testEncryptDecryptKCaesarThousand() {
//        String decrypted = kcaesar.decrypt("cdefghjklm", 5);
//        assertEquals("abcdefghij", decrypted);
//
//        long start = System.nanoTime();
//        long end = System.nanoTime();
//        long sum = 0;
//        String plain = "";
//        String encrypted;
//        for (int j = 1; j < 21; j++) {
//            sum = 0;
//            for (int i = 0; i < 1000; i++) {
//                plain = plain.concat("abcdefghij");
//                start = System.nanoTime();
//                kcaesar = new KeyedCaesar("avain");
//                encrypted = kcaesar.decrypt(plain, 5);
//                end = System.nanoTime();
//                sum += end - start;
//            }
//
//            if (j != 20) {
//                System.out.print(sum / 1000000 + ",");
//            } else {
//                System.out.println(sum / 1000000);
//            }
//        }
//        for (int j = 1; j < 21; j++) {
//            sum = 0;
//
//            String crypt = "";
//            for (int i = 0; i < 1000; i++) {
//                crypt = crypt.concat("cdefghjklm");
//                start = System.nanoTime();
//                kcaesar = new KeyedCaesar("avain");
//                decrypted = kcaesar.decrypt(crypt, 5);
//                end = System.nanoTime();
//                sum += end - start;
//            }
//
//            if (j != 20) {
//                System.out.print(sum / 1000000 + ",");
//            } else {
//                System.out.println(sum / 1000000);
//            }
//        }
//
//        decrypted = kcaesar.decrypt("ygxyqgxxcjg", 5);
//
//    }
}
