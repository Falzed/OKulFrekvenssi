/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.okulfrekvenssi.Analyysi;

import tiralabra.okulfrekvenssi.util.Alphabet;
import tiralabra.okulfrekvenssi.Ciphers.Vigenere;
import tiralabra.okulfrekvenssi.util.OmaHash;

/**
 *
 * @author Oskari
 */
public class VigenereAnalysis {

    /**
     * Jakaa salatun tekstin koseteihin, eli jos teksti on abcdefghij ja 
     * salasana on 4 merkkiä kosetit ovat aei, bfj, cg, dh
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

    /**
     * Paras arvaus salaamattomalle tekstille. Jakaa salatun tekstin ensin i
     * sivuluokkaan, sitten laskee kosettien frekvenssien poikkeaman englannin 
     * frekvensseistä samoin kuin Caesar-analyysissä ja ottaa keskiarvon. 
     * Valitaan sivuluokkien määrä jolla saadaan pienin keskiarvo, ja dekryptataan
     * sillä arvauksella.
     * @param ciphertext salattu teksti
     * @param alphabet aakkosto
     * @return (toivottavasti oikein) dekryptattu teksti
     */
    public static String bestGuess(String ciphertext, char[] alphabet) {
        Vigenere vig = new Vigenere(alphabet);
        String abc = new String(alphabet);
        String ABC = new String(alphabet).toUpperCase();
        String cipherPruned = Alphabet.removeAllBut(ciphertext, abc.concat(ABC));
        OmaHash<Integer, Character> hashIntChar = Alphabet.createIntCharHash(alphabet);
        int maxPassLength = (cipherPruned.length() > 50) ? 50 : cipherPruned.length();
//        double[] normFrequencyAvgs = new double[maxPassLength];
        int[][] bestGuesses = new int[maxPassLength][maxPassLength];
        String[] passphraseGuesses = new String[maxPassLength];
        double min = Double.MAX_VALUE;
        int bestLength = -1;
        for (int i = 1; i < maxPassLength + 1; i++) {
            String[] cosets = getCosets(cipherPruned.toLowerCase(), i);
            passphraseGuesses[i - 1] = "";
            double avg = 0;
            for (int j = 0; j < i; j++) {
                bestGuesses[i - 1][j] = CaesarAnalysis.bestGuess(cosets[j], alphabet);
                String uusi = hashIntChar.get(bestGuesses[i - 1][j]).toString();
                passphraseGuesses[i - 1] = passphraseGuesses[i - 1].concat(uusi);
                avg += CaesarAnalysis.getNormalizedFrequenciesSum(cosets[j],
                        bestGuesses[i - 1][j], alphabet);
            }
            avg = avg / i;
//            normFrequencyAvgs[i - 1] = avg;
            if (avg < min) {
                min = avg;
                bestLength = i;
            }
        }

        return (bestLength == -1) ? "Some kind of error occured in analysis"
                : vig.decrypt(ciphertext, passphraseGuesses[bestLength - 1]);

    }
    
    
}
