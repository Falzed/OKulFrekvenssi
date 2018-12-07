/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.okulfrekvenssi.util;

import tiralabra.okulfrekvenssi.util.OmaHash;

/**
 *
 * @author Oskari
 */
public class Alphabet {

    /**
     * Suomalaiset aakkoset
     */
    public final static char[] SUOMI = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
        'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
        'w', 'x', 'y', 'z', 'å', 'ä', 'ö'};

    /**
     * Suomalaiset isot kirjaimet
     */
    public final static char[] SUOMI_CAPS = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
        'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
        'W', 'X', 'Y', 'Z', 'Å', 'Ä', 'Ö'};

    /**
     * Englantilaiset aakkoset
     */
    public final static char[] ENGLISH = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
        'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
        'w', 'x', 'y', 'z'};

    /**
     * Englantilaiset isot kirjaimet
     */
    public final static char[] ENGLISH_CAPS = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
        'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
        'W', 'X', 'Y', 'Z'};

    /**
     * hash jossa avaimina suomalaiset aakkoset, arvoina järjestysluvut
     */
    public final static OmaHash<Character, Integer> SUOMI_CHAR_INT = new OmaHash<>();

    /**
     * avaimina isot suomalaiset kirjaimet, arvoina järjestysluvut
     */
    public final static OmaHash<Character, Integer> SUOMI_CAPS_CHAR_INT = new OmaHash<>();

    /**
     * hash jossa avaimina järjestysluvut, arvoina suomalaiset aakkoset
     */
    public final static OmaHash<Integer, Character> SUOMI_INT_CHAR = new OmaHash<>();

    /**
     * avaimina järjestysluvut, arvoina isot suomalaiset kirjaimet
     */
    public final static OmaHash<Integer, Character> SUOMI_CAPS_INT_CHAR = new OmaHash<>();

    /**
     * hash jossa avaimina englantilaiset aakkoset, arvoina järjestysluvut
     */
    public final static OmaHash<Character, Integer> ENGLISH_CHAR_INT = new OmaHash<>();

    /**
     * avaimina isot englantilaiset kirjaimet, arvoina järjestysluvut
     */
    public final static OmaHash<Character, Integer> ENGLISH_CAPS_CHAR_INT = new OmaHash<>();

    /**
     * hash jossa avaimina järjestysluvut, arvoina englantilaiset aakkoset
     */
    public final static OmaHash<Integer, Character> ENGLISH_INT_CHAR = new OmaHash<>();

    /**
     * avaimina isot englantilaiset aakkoset, arvoina järjestysluvut
     */
    public final static OmaHash<Integer, Character> ENGLISH_CAPS_INT_CHAR = new OmaHash<>();

    /**
     * tällä hetkellä ei käytössä
     */
    public final static char[] PUNCTUATION = new char[]{',', '.', '!', '?', '-',
        ':', ';', '(', ')'};

    /**
     * Tarkistaa onko annettu merkki pieni suomalainen aakkonen
     *
     * @param c merkki
     * @return onko suomalainen pieni kirjain
     */
    public static boolean isFinnishLetter(char c) {
        for (char a : SUOMI) {
            if (a == c) {
                return true;
            }
        }
//        for(char a:SUOMI_CAPS) {
//            if(a==c) {return true;}
//        }
        return false;
    }

    /**
     * Tarkistaa onko annettu merkki iso suomalainen aakkonen
     *
     * @param c
     * @return
     */
    public static boolean isCapitalFinnishLetter(char c) {
//        for(char a:SUOMI) {
//            if(a==c) {return true;}
//        }
        for (char a : SUOMI_CAPS) {
            if (a == c) {
                return true;
            }
        }
        return false;
    }

    //Turha
//    public static boolean isPunctuation(char c) {
//        for (char a : PUNCTUATION) {
//            if (a == c) {
//                return true;
//            }
//        }
//        return false;
//    }
    /**
     * Poistaa annetusta merkkijonosta kaikki merkit jotka ovat toisessa
     * merkkijonossa
     *
     * @param mjono merkkijono mistä poistetaan
     * @param charactersToRemove mitkä merkit poistetaan
     * @return merkkijono ilman poistettuja merkkejä
     */
    public static String removeAll(String mjono, String charactersToRemove) {
        String removed = "";
        for (char c : mjono.toCharArray()) {
            boolean remove = false;
            for (char d : charactersToRemove.toCharArray()) {
                if (c == d) {
                    remove = true;
                }
            }
            removed = remove ? removed : removed.concat(String.valueOf(c));
        }
        return removed;
    }

    /**
     * Poistaa annetusta merkkijonosta kaikki merkit jotka eivät ole toisessa
     * merkkijonossa
     *
     * @param mjono merkkijono mistä poistetaan
     * @param charactersToNotRemove merkit joita ei poisteta
     * @return merkkijono ilman poistettuja merkkejä
     */
    public static String removeAllBut(String mjono, String charactersToNotRemove) {
        String removed = "";
//        System.out.println("mjono:");
//        System.out.println(mjono);
//        System.out.println("charactersToNotRemove:");
//        System.out.println(charactersToNotRemove);
        for (char c : mjono.toCharArray()) {
            boolean remove = true;
            for (char d : charactersToNotRemove.toCharArray()) {
                if (c == d) {
                    remove = false;
                }
            }
            removed = remove ? removed : removed.concat(String.valueOf(c));
        }
        return removed;
    }

    static {
        int i = 0;
        for (char c : SUOMI) {
            SUOMI_CHAR_INT.put(c, i);
            SUOMI_INT_CHAR.put(i, c);
            i++;
        }
        i = 0;
        for (char c : SUOMI_CAPS) {
            SUOMI_CAPS_CHAR_INT.put(c, i);
            SUOMI_CAPS_INT_CHAR.put(i, c);
            i++;
        }
        i = 0;
        for (char c : ENGLISH) {
            ENGLISH_CHAR_INT.put(c, i);
            ENGLISH_INT_CHAR.put(i, c);
            i++;
        }
        i = 0;
        for (char c : ENGLISH_CAPS) {
            ENGLISH_CAPS_CHAR_INT.put(c, i);
            ENGLISH_CAPS_INT_CHAR.put(i, c);
            i++;
        }
    }
    public static OmaHash<Character, Integer> createCharIntHash(char[] abc) {
        OmaHash<Character, Integer> hash = new OmaHash<>();
        for(int i=0; i<abc.length; i++) {
            hash.put(abc[i], i);
        }
        return hash;
    }
    public static OmaHash<Integer, Character> createIntCharHash(char[] abc) {
        OmaHash<Integer, Character> hash = new OmaHash<>();
        for(int i=0; i<abc.length; i++) {
            hash.put(i, abc[i]);
        }
        return hash;
    }
}
