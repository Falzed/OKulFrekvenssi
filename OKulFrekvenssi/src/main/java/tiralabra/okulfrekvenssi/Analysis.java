/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.okulfrekvenssi;

/**
 *
 * @author Oskari
 */
public class Analysis {
    private final static char[] ALPHABET = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z', 'å', 'ä', 'ö'};
    //http://pi.math.cornell.edu/~mec/2003-2004/cryptography/subs/frequencies.html
    public final static int[] ENGLISH_FREQUENCY = 
            new int[] {14810, 2715, 4983, 7874, 21912,
                        4200, 3693, 10795, 13318, 188, 
                        1267, 7253, 4761, 12666, 14003,
                        3316, 205, 10977, 11450, 16587,
                        5246, 2019, 3019, 315, 3853,
                        0, 0, 0
            };

    /**
     *
     * @param crypted
     * @return
     */
    public static int[] calcFrequencies(String crypted) {
        int[] freq = new int[29];
        for(int i=0; i<ALPHABET.length; i++) {
            int count = 0;
            for(char c : crypted.toCharArray()) {
                if(c==ALPHABET[i]) {
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
     * @param ciphertext
     * @return
     */
    public static double[] normalizedFrequencies(String ciphertext) {
        int[] freq = calcFrequencies(ciphertext);
        int sum = 0;
        for(int i : freq) {
            sum += i;
        }
//        System.out.println(sum);
        double sigma = 0;
        int n = freq.length;
        double avg = ((double) sum / (double) n);    
//        System.out.println(avg);
        for (int i:freq) {
            sigma += Math.pow((double) i - avg, 2);
//            System.out.println(Math.pow((double) i - avg, 2));
        }
        sigma = sigma/(n-1);
        sigma = Math.sqrt(sigma);
        
//        System.out.println("sigma: "+sigma);
                
        double[] normalized = new double[freq.length];
        for(int i=0; i<freq.length; i++) {
            normalized[i] = ((double) freq[i] - avg)/sigma;
        }
        return normalized;
    }
}
