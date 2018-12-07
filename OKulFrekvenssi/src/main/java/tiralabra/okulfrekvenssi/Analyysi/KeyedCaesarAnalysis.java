/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.okulfrekvenssi.Analyysi;

import java.util.Arrays;
import tiralabra.okulfrekvenssi.util.Alphabet;
import tiralabra.okulfrekvenssi.util.OmaHash;
import tiralabra.okulfrekvenssi.util.OmaTuple;
import tiralabra.okulfrekvenssi.Ciphers.KeyedCaesar;

/**
 *
 * @author Oskari
 */
public class KeyedCaesarAnalysis {

    /**
     * (liian hidas) Arvioi parhaan offestin annetulla avaimella
     *
     * @param cipher
     * @param beginKey
     * @param off
     * @param abc
     * @return
     */
    public static Object[] bestOffsetForKey(String cipher, String beginKey, int off, char[] abc) {
        if (off >= abc.length) {
            return null;
        }
        beginKey += String.valueOf(abc[off]);
        String vanha = Alphabet.removeAll(new String(abc), beginKey);
        String uusi = beginKey + vanha;
        char[] newAbc = uusi.toCharArray();
        double min = Double.MAX_VALUE;
        int bestOffset = -1;
        for (int i = 0; i < newAbc.length; i++) {
//            System.out.println("cipher: " + cipher + ", i: " + i + ", newAbc: " + new String(newAbc));
            double normFreq = CaesarAnalysis.getNormalizedFrequenciesSum(cipher, i, newAbc);
            normFreq /= newAbc.length;
            if (normFreq < min) {
                min = normFreq;
                bestOffset = i;
            }
        }
        Object[] ret = new Object[2];
        ret[0] = min;
        ret[1] = bestOffset;
        return ret;
    }

    /**
     * (liian hidas) Arvioi parhaan avaimen ja offsetin
     *
     * @param cipher
     * @param maxLength
     * @param beginKey
     * @param abc
     * @param best
     * @return
     */
    public static Object[] bestKeyRecursive(String cipher, int maxLength,
            String beginKey, char[] abc, Object[] best) {

        if (beginKey.length() + 3 < maxLength) {
            System.out.println("beginKey length: " + beginKey.length());
        }
        if (beginKey.length() >= maxLength) {
            return best;
        }
        if (beginKey.length() == maxLength - 1) {
            Object[] guess = bestKeyForBeginning(cipher, beginKey, abc);
            return (double) guess[0] < (double) best[0] ? guess : best;
        }
        for (int i = 0; i < abc.length; i++) {
            if (!beginKey.contains(String.valueOf(abc[i]))) {
                String newKey = beginKey + String.valueOf(abc[i]);
                Object[] arr = bestKeyRecursive(cipher, maxLength, newKey, abc, best);
                if ((double) arr[0] < (double) best[0]) {
//                    System.out.println((double) arr[0] + ", " + (int) arr[1] + ", " + (String) arr[2]);
                    best = arr;
                }
            }
        }
        return best;
    }

    /**
     * (liian hidas) Arvioi parhaan seuraavan kirjaimen avaimeen
     *
     * @param cipher
     * @param beginKey
     * @param abc
     * @return
     */
    public static Object[] bestKeyForBeginning(String cipher, String beginKey, char[] abc) {
        double min = Double.MAX_VALUE;
        int bestOffset = -1;
        String bestKey = "";
        for (int i = 0; i < abc.length; i++) {
            if (!beginKey.contains(String.valueOf(abc[i]))) {
                Object[] arr = bestOffsetForKey(cipher, beginKey, i, abc);
                if ((double) arr[0] < min) {
                    min = (double) arr[0];
                    bestOffset = (int) arr[1];
                    bestKey = beginKey + String.valueOf(abc[i]);
                }
            }
        }
        return new Object[]{min, bestOffset, bestKey};
    }

    /**
     * (ei realistinen ratkaisu) Olettaa että merkkien frekvenssien suuruusjärjestys tekstissä on sama kuin englannissa. Toimisi varmaan tarpeeksi suurella aineistolla
     * @param cipher
     * @param abc
     * @return
     */
    public static String simpleGuess(String cipher, char[] abc) {
        OmaHash<Character, Integer> letterCount = new OmaHash<>();
        OmaTuple[] lCount = new OmaTuple[abc.length];
        for (char c : Alphabet.removeAllBut(cipher.toLowerCase(), new String(abc)).toCharArray()) {
            if (letterCount.get(c) == null) {
                letterCount.put(c, 1);
            } else {
                letterCount.put(c, letterCount.get(c) + 1);
            }
        }
        for (int i = 0; i < abc.length; i++) {
            if (letterCount.get(abc[i]) == null) {
                lCount[i] = new OmaTuple(0, abc[i]);
            } else {
                lCount[i] = new OmaTuple(letterCount.get(abc[i]), abc[i]);
            }
        }
        lCount = omaMergeSort(lCount);
        OmaTuple[] engCount = new OmaTuple[abc.length];
        for (int i = 0; i < abc.length; i++) {
            engCount[i] = new OmaTuple(Analysis.ENGLISH_FREQUENCY[i], abc[i]);
        }
        engCount = omaMergeSort(engCount);
        
        System.out.println(lCount[1].toString());
        System.out.println(engCount[1].toString());
        
        OmaHash<Character, Character> mapping = new OmaHash<>();
        for (int i = 0; i < abc.length; i++) {
            mapping.put(engCount[i].getMerkki(), lCount[i].getMerkki());
        }
        char[] newAbc = new char[abc.length];
        for (int i = 0; i < abc.length; i++) {
            newAbc[i] = mapping.get(abc[i]);
        }
        System.out.println(Arrays.toString(abc));
        System.out.println(Arrays.toString(newAbc));
//        System.out.println(newAbc);
//
//        String plain = "";
//        for(char c:cipher.toCharArray()) {
//            
//        }
        KeyedCaesar kcaesar = new KeyedCaesar(new String(newAbc));
        return kcaesar.decrypt(cipher, 0);
    }

    /**
     *
     * @param unsorted
     * @return
     */
    public static OmaTuple[] omaMergeSort(OmaTuple[] unsorted) {
        OmaTuple[] copy = unsorted.clone();
        sort(copy, 0, unsorted.length - 1);
        return copy;
    }

    private static void sort(OmaTuple[] unsorted, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            sort(unsorted, left, middle);
            sort(unsorted, middle + 1, right);
            merge(unsorted, left, middle, right);
        }
    }

    private static void merge(OmaTuple[] arr, int left, int middle, int right) {
        OmaTuple[] L = new OmaTuple[middle - left + 1];
        OmaTuple[] R = new OmaTuple[right - middle];

        for (int i = 0; i < middle - left + 1; i++) {
            L[i] = arr[left + i];
        }
//        System.out.println(left + ", " + middle + ", " + right);
        for (int i = 0; i < right - middle; i++) {
            R[i] = arr[middle + i + 1];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < middle - left + 1 && j < right - middle) {
            if (L[i].getInt() >= R[j].getInt()) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < middle - left + 1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < right - middle) {
            arr[k] = R[j];
            j++;
            k++;
        }
//        System.out.println(Arrays.toString(arr));

    }

}
