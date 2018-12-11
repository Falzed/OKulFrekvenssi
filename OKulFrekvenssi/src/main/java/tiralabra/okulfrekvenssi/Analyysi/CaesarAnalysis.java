/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.okulfrekvenssi.Analyysi;

import tiralabra.okulfrekvenssi.Ciphers.Caesar;

/**
 *
 * @author Oskari
 */
public class CaesarAnalysis {

    /**
     * 
     * @param ciphertext salattu teksti jota analysoidaan
     * @param alphabet käytettävä aakkosto (käytännössä ääkkösten kanssa vai
     * ilman)
     * @return paras arvaus mikä salauksen offset on (millä kirjainten
     * frekvenssit poikkeavat vähiten englannista)
     */
    public static int bestGuess(String ciphertext, char[] alphabet) {
        double min = Double.MAX_VALUE;
        int a = -1;
        for (int i = 0; i < alphabet.length; i++) {
            double sum = getNormalizedFrequenciesSum(ciphertext, i, alphabet);
            if (sum < min) {
                min = sum;
                a = i;
            }
//            System.out.println("i="+i+", sum="+sum);
        }
        return a;
    }

    /**
     * Laskee annetulla offsetilla dekryptatun tekstin frekvenssien poikkeaman
     * englannista (normalisoituna).
     * @param ciphertext salattu teksti
     * @param offset kuinka paljon shiftataan merkkejä
     * @return frekvenssien normalisoitu poikkeama englannista
     */
    public static double getNormalizedFrequenciesSum(String ciphertext,
            int offset, char[] alphabet) {
        Caesar caesar = new Caesar();
        double[] normEnglish = Analysis.ENGLISH_NORMALIZED_FREQUENCY;

        double[] normalized = Analysis.normalizedFrequencies(
                caesar.decrypt(ciphertext, offset, alphabet), alphabet
        );

        double sum = 0;
        for (int j = 0; j < normalized.length; j++) {
            sum += Math.abs(normalized[j] - normEnglish[j]);
        }

        return sum;
    }
}
