/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.okulfrekvenssi.Analyysi;

/**
 *
 * @author Oskari
 */
public class Analysis {

    /**
     * suomalaiset aakkoset
     */
    public final static char[] ALPHABET = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
        'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
        'w', 'x', 'y', 'z', 'å', 'ä', 'ö'};
    

    /**
     * Englanninkielisen korpuksen merkkien määrät, lähteenä
     * http://pi.math.cornell.edu/~mec/2003-2004/cryptography/subs/frequencies.html
     */
    public final static int[] ENGLISH_FREQUENCY
            = new int[]{14810, 2715, 4943, 7874, 21912,
                4200, 3693, 10795, 13318, 188,
                1257, 7253, 4761, 12666, 14003,
                3316, 205, 10977, 11450, 16587,
                5246, 2019, 3819, 315, 3853,
                128, 0, 0, 0
            };

    /**
     * ero aritmeettisesta keskiarvosta keskihajonnan kertoimena
     */
    public final static double[] ENGLISH_NORMALIZED_FREQUENCY
            = new double[]{
                1.4229115, -0.5961806, -0.2242470, 0.2650427, 2.6084917, 
                -0.3482805, -0.4329171, 0.7526631, 1.1738429, -1.0180282,
                -0.8395735, 0.1613754, -0.2546294, 1.0650005, 1.2881941,
                -0.4958520, -1.0151903, 0.7830455, 0.8620062, 1.7195570,
                -0.1736654, -0.7123682, -0.4118832, -0.9968273, -0.4062073,
                -1.0280443, -1.0494122, -1.0494122, -1.0494122
            };

    /**
     *
     * @param crypted salattu teksti
     * @return frekvenssit
     */
    public static int[] calcFrequencies(String crypted) {
        int[] freq = new int[29];
        for (int i = 0; i < ALPHABET.length; i++) {
            int count = 0;
            for (char c : crypted.toCharArray()) {
                if (c == ALPHABET[i]) {
                    count++;
                }
            }
            freq[i] = count;
        }
        return freq;
    }

    //laskee merkkien frekvenssin 
    //poikkeaman keskiarvosta keskihajonnan kertoimena syötteessä
    //varmaan menee turhan monimutkaiseksi, mutta saattaa olla hyödyllinen
    /**
     *
     * @param ciphertext salattu teksti
     * @return frekvenssien ero aritmeettisesta keskiarvosta keskihajonnan 
     * kertoimena
     */
    public static double[] normalizedFrequencies(String ciphertext) {
        int[] freq = calcFrequencies(ciphertext);
        int sum = 0;
        for (int i : freq) {
            sum += i;
        }
//        System.out.println(sum);
        double sigma = 0;
        int n = freq.length;
        double avg = ((double) sum / (double) n);
//        System.out.println(avg);
        for (int i : freq) {
            sigma += Math.pow((double) i - avg, 2);
//            System.out.println(Math.pow((double) i - avg, 2));
        }
        sigma = sigma / (n - 1);
        sigma = Math.sqrt(sigma);

//        System.out.println("sigma: "+sigma);
        double[] normalized = new double[freq.length];
        for (int i = 0; i < freq.length; i++) {
            normalized[i] = ((double) freq[i] - avg) / sigma;
        }
        return normalized;
    }
}
