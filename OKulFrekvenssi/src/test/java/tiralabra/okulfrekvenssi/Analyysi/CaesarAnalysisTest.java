/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.okulfrekvenssi.Analyysi;

import tiralabra.okulfrekvenssi.Analyysi.CaesarAnalysis;
import tiralabra.okulfrekvenssi.Analyysi.Analysis;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import tiralabra.okulfrekvenssi.util.Alphabet;
import tiralabra.okulfrekvenssi.Ciphers.Caesar;

/**
 *
 * @author Oskari
 */
public class CaesarAnalysisTest {

    public CaesarAnalysisTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of bestGuess method, of class CaesarAnalysis.
     */
    @Test
    public void testBestGuess() {
        System.out.println("bestGuess");
        String ciphertext = "Bring upon sixth all yielding waters firmament, own third days fill he deep lights called life unto meat every land were. Seas also rule.\n"
                + "\n"
                + "For won't day female fowl set his herb created spirit greater, his beast day land itself you're third evening created whose, dry firmament together multiply light gathering all replenish he creature.\n"
                + "\n"
                + "Fly herb let given sea she'd i gathering seed place meat seas after air, to. Made. It replenish. Unto. Fill together. Male void. Own a saying fill upon lesser appear very made is that. To let you. Whose lights image. Grass can't. Whose multiply after.";
        char[] alphabet = Alphabet.SUOMI;
        int expResult = 0;
        int result = CaesarAnalysis.bestGuess(ciphertext, alphabet);
        assertEquals(expResult, result);
    }

    @Test
    public void testBestGuessMillion() {
        
        String ciphertext = "Bring upon sixth all yielding waters firmament, own third days fill he deep lights called life unto meat every land were. Seas also rule.\n"
                + "\n"
                + "For won't day female fowl set his herb created spirit greater, his beast day land itself you're third evening created whose, dry firmament together multiply light gathering all replenish he creature.\n"
                + "\n"
                + "Fly herb let given sea she'd i gathering seed place meat seas after air, to. Made. It replenish. Unto. Fill together. Male void. Own a saying fill upon lesser appear very made is that. To let you. Whose lights image. Grass can't. Whose multiply after.";
        Caesar caesar = new Caesar();
        ciphertext = caesar.encrypt(ciphertext, 10, Alphabet.ENGLISH);
        char[] alphabet = Alphabet.ENGLISH;
        int expResult = 0;
        String cipher = "";
        long start = System.nanoTime();
        long end = System.nanoTime();
        for (int j = 1; j < 21; j++) {
            cipher = cipher.concat(ciphertext);
            long sum = 0;
            for (int i = 0; i < 100; i++) {
                start = System.nanoTime();
                int result = CaesarAnalysis.bestGuess(cipher, alphabet);
                end = System.nanoTime();
                sum += end-start;
            }
            if (j != 20) {
                System.out.print(sum / 100000 + ",");
            } else {
                System.out.println(sum / 100000);
            }
        }
    }

}
