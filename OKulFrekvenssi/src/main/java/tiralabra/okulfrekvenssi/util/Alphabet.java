/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.okulfrekvenssi.util;

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
     * Tarkistaa kuuluuko annettu merkki annettuihin aakkosiin
     *
     * @param c merkki
     * @param abc aakkoset
     * @return onko merkki annetuissa aakkosissa
     */
    public static boolean isLetter(char c, char[] abc) {
        for (char a : abc) {
            if (a == c) {
                return true;
            }
        }
        return false;
    }

//    /**
//     * Tarkistaa onko annettu merkki iso suomalainen aakkonen
//     *
//     * @param c annettu merkki
//     * @return onko suomalainen aakkonen
//     */
//    public static boolean isCapitalFinnishLetter(char c) {
//        for (char a : SUOMI_CAPS) {
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
    
    /**
     * Poistaa merkkijonosta duplikaattikirjaimet, esim avain-avin
     * @param mjono alkuperäinen merkkijono
     * @param abc aakkoset
     * @return merkkijono ilman duplikaatteja
     */
    public static String removeDuplicates(String mjono, char[] abc) {
        char[] arr = mjono.toCharArray();
        OmaHash<Character, Boolean> added = new OmaHash<>();
        for(char c:abc) {
            added.put(c, Boolean.FALSE);
        }
        char[] removed = new char[arr.length];
        int j=0;
        for(int i=0; i<arr.length; i++) {
            if(!added.get(arr[i])) {
                removed[j] = arr[i];
                j++;
                added.put(arr[i], Boolean.TRUE);
            }
        }
        char[] res = new char[j]; 
        for(int i=0; i<j; i++) {
            res[i] = removed[i];
        }
        return new String(res);
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

    /**
     * Luo OmaHashin annetun aakkoston perusteella, avaimina merkit ja arvoina
     * järjestysluku, esim a-0, b-1 jne
     *
     * @param abc käytetty aakkosto
     * @return OmaHash jossa avaimina merkit ja arvoina järjestysluvut
     */
    public static OmaHash<Character, Integer> createCharIntHash(char[] abc) {
        OmaHash<Character, Integer> hash = new OmaHash<>();
        for (int i = 0; i < abc.length; i++) {
            hash.put(abc[i], i);
        }
        return hash;
    }

    /**
     * Luo OmaHashin annetun aakkoston perusteella, avaimina järjestysluku ja 
     * arvoina merkit, esim 0-a, 1-b jne
     *
     * @param abc käytetty aakkosto
     * @return OmaHash jossa avaimina järjestysluvut ja arvoina merkit 
     */
    public static OmaHash<Integer, Character> createIntCharHash(char[] abc) {
        OmaHash<Integer, Character> hash = new OmaHash<>();
        for (int i = 0; i < abc.length; i++) {
            hash.put(i, abc[i]);
        }
        return hash;
    }
}
