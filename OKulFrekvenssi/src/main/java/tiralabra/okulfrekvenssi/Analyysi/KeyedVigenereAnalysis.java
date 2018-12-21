/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.okulfrekvenssi.Analyysi;

import tiralabra.okulfrekvenssi.util.Alphabet;
import tiralabra.okulfrekvenssi.Ciphers.Vigenere;

/**
 *
 * @author Oskari
 */
public class KeyedVigenereAnalysis {

    /**
     * Jakaa salatun tekstin koseteihin, eli jos teksti on abcdefghij ja
     * salasana on 4 merkkiä kosetit ovat aei, bfj, cg, dh
     *
     * @param ciphertext salattu teksti
     * @param passLength salasanan pituus
     * @return kosetit
     */
    public static String[] getCosets(String ciphertext, int passLength) {
        String[] cosets = new String[passLength];
        for (int i = 0; i < cosets.length; i++) {
            cosets[i] = "";
        }
        for (int i = 0; i < ciphertext.length(); i++) {
//            System.out.println("i="+i+", cosets["+(i%passLength)+"]: "+cosets[i%passLength]);
            cosets[i % passLength] = cosets[i % passLength].concat(ciphertext.substring(i, i + 1));
        }
        return cosets;
    }

    public static int find(char c, char[] abc) {
        for (int i = 0; i < abc.length; i++) {
            if (abc[i] == c) {
                return i;
            }
        }
        return -1;
    }

    /**
     * (KESKEN) Paras arvaus salaamattomalle tekstille. Jakaa salatun tekstin
     * ensin i sivuluokkaan.
     *
     * @param ciphertext salattu teksti
     * @param alphabet aakkosto
     * @return (toivottavasti oikein) dekryptattu teksti
     */
    public static String bestGuess(String ciphertext, char[] alphabet) {
        Vigenere vig = new Vigenere(alphabet);
        int maxPassLength = (ciphertext.length() > 50) ? 50 : ciphertext.length();
        int maxKeyLength = 10;
//        double[] normFrequencyAvgs = new double[maxPassLength];
        int[][] bestGuesses = new int[maxPassLength][maxPassLength];
        String[] passphraseGuesses = new String[maxPassLength];
        double min = Double.MAX_VALUE;
        int bestLength = -1;
        char[] abc = Alphabet.SUOMI;
        for (int i = 1; i < maxPassLength + 1; i++) {
            String[] cosets = getCosets(ciphertext, i);
            String keyGuess = "";
            for (int j = 1; j < maxKeyLength; j++) {
                double minKey = Double.MAX_VALUE;
                char bestKey = '#';
                char[] modAbc = Alphabet.SUOMI;
                for (int k = 0; k < alphabet.length; k++) {
                    String keyGuess2 = keyGuess.concat(String.valueOf(abc[k]));
                    int apu = find(abc[k], modAbc);

                    String temp = (new String(modAbc)).substring(apu + 1, modAbc.length);
                    if (j == 1) {
                        modAbc = String.valueOf(modAbc[apu]).concat((new String(modAbc)).substring(0, apu)).concat(temp).toCharArray();
                    } else {
                        modAbc = (new String(modAbc)).substring(0, j - 2).concat(String.valueOf(modAbc[apu])).concat((new String(modAbc)).substring(j, apu)).concat(temp).toCharArray();
                    }
                    String g = VigenereAnalysis.bestGuess(ciphertext, modAbc);

                }
                keyGuess = keyGuess.concat(String.valueOf(bestKey));
            }
        }
        for (int i = 1; i < maxPassLength + 1; i++) {
            //iterating through coset length
            String[] cosets = getCosets(ciphertext, i);

            for (String coset : cosets) {
                for (int j = 1; j < maxKeyLength; j++) {
                    //passwords of length j
                    for(int k=0; k<abc.length; k++) {
                        //iterate alphabet
                    }
                }

            }
        }

//        for(String guess:passphraseGuesses) {
//            System.out.println(guess);
//        }
        return (bestLength == -1) ? "Some kind of error occured in analysis"
                : vig.decrypt(ciphertext, passphraseGuesses[bestLength - 1]);

    }
}
