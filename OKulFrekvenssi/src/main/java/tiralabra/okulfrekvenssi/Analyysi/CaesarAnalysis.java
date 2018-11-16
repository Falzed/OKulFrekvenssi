/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.okulfrekvenssi.Analyysi;

import tiralabra.okulfrekvenssi.Analyysi.Analysis;
import tiralabra.okulfrekvenssi.Ciphers.Caesar;

/**
 *
 * @author Oskari
 */
public class CaesarAnalysis {

    /**
     *
     * @param ciphertext salattu teksti jota analysoidaan
     * @param alphabet käytettävä aakkosto (käytännössä ääkkösten kanssa vai ilman)
     * @return paras arvaus mikä salauksen offset on (millä kirjainten frekvenssit poikkeavat vähiten englannista)
     */
    public static int bestGuess(String ciphertext, char[] alphabet) {
        Caesar caesar = new Caesar();
        double[] normEnglish = Analysis.ENGLISH_NORMALIZED_FREQUENCY;
        double min = Double.MAX_VALUE;
        int a = -1;
        for (int i = 0; i < alphabet.length; i++) {
            double[] normalized = Analysis.normalizedFrequencies(
                    caesar.decrypt(ciphertext, i)
            );
            
            double sum = 0;
            for (int j=0; j<normalized.length; j++) {
                sum += Math.abs(normalized[j]-normEnglish[j]);
            }
            if (sum < min) {
                min = sum;
                a = i;
            }
//            System.out.println("i="+i+", sum="+sum);
        }
        return a;
    }
}
