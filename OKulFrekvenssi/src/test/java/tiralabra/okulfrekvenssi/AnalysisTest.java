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
public class AnalysisTest {

    public AnalysisTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of calcFrequencies method, of class Analysis.
     */
    @Test
    public void testCalcFrequencies() {
        System.out.println("calcFrequencies");
        String crypted = "asqqwsfawq";
        int[] expResult = new int[29];
        expResult[0] = 2;
        expResult[16] = 3;
        expResult[5] = 1;
        expResult[22] = 2;
        expResult[18] = 2;
        int[] result = Analysis.calcFrequencies(crypted);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of normalizedFrequencies method, of class Analysis.
     */
    @Test
    public void testNormalizedFrequencies() {
        System.out.println("normalizedFrequencies");
        String ciphertext = "aab";
        double[] expResult = new double[29];
        double sigma = Math.sqrt(
                (Math.pow((double) 26 / (double) 29, 2)
                + Math.pow((double) 55 / (double) 29, 2)
                + 27 * Math.pow((double) 3 / (double) 29, 2)) / 28);
//        System.out.println(sigma);

        expResult[0] = (double) 55 / (double) 29 / sigma;
        expResult[1] = (double) 26 / (double) 29 / sigma;
        for (int i = 2; i < 29; i++) {
            expResult[i] = -(double) 3 / (double) 29 / sigma;
        }
        double[] result = Analysis.normalizedFrequencies(ciphertext);
        assertArrayEquals(expResult, result, 0.001);
    }

}
