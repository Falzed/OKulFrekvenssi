/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.okulfrekvenssi.Analyysi;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import tiralabra.okulfrekvenssi.Ciphers.Vigenere;
import tiralabra.okulfrekvenssi.util.Alphabet;

/**
 *
 * @author Oskari
 */
public class VigenereAnalysisTest {

    public VigenereAnalysisTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCosets() {
        System.out.println("Coset test");
        String ciphertext = "jihjcihitkw";
        String[] expectedResult = new String[]{"jct", "iik", "hhw", "ji"};
        String[] result = VigenereAnalysis.getCosets(ciphertext, 4);
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testGuess() {
        Vigenere vig = new Vigenere(Alphabet.SUOMI);
        String plaintext = "Bring upon sixth all yielding waters firmament, own third days fill he deep lights called life unto meat every land were. Seas also rule.\n"
                + "\n"
                + "For won't day female fowl set his herb created spirit greater, his beast day land itself you're third evening created whose, dry firmament together multiply light gathering all replenish he creature.\n"
                + "\n"
                + "Fly herb let given sea she'd i gathering seed place meat seas after air, to. Made. It replenish. Unto. Fill together. Male void. Own a saying fill upon lesser appear very made is that. To let you. Whose lights image. Grass can't. Whose multiply after.";
        String ciphertext = vig.encrypt(plaintext, "test");
        System.out.println("expectedResult:");

//        String expectedResult = plaintext.toLowerCase().replaceAll("[^a-z]", "");
        String expectedResult = plaintext;
        System.out.println(expectedResult);
        String result = VigenereAnalysis.bestGuess(ciphertext, Alphabet.SUOMI);
        System.out.println("result:");
        System.out.println(result);
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void testEnglish() {
        Vigenere vig = new Vigenere(Alphabet.ENGLISH);
        String res = VigenereAnalysis.bestGuess("Ihak xs s ltsl etsksve, hdtakw xgfgge", Alphabet.ENGLISH);
        assertEquals("This is a test message, please ignore", res);
    }
}
