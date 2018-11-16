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
     * Englantilaiset aakkoset
     */
    public final static char[] ENGLISH = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
        'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
        'w', 'x', 'y', 'z'};

    /**
     * hash jossa avaimina suomalaiset aakkoset, arvoina järjestysluvut
     */
    public final static OmaHash<Character, Integer> SUOMI_CHAR_INT = new OmaHash<>();

    /**
     * hash jossa avaimina järjestysluvut, arvoina suomalaiset aakkoset
     */
    public final static OmaHash<Integer, Character> SUOMI_INT_CHAR = new OmaHash<>();

    /**
     *  hash jossa avaimina englantilaiset aakkoset, arvoina järjestysluvut
     */
    public final static OmaHash<Character, Integer> ENGLISH_CHAR_INT = new OmaHash<>();

    /**
     * hash jossa avaimina järjestysluvut, arvoina englantilaiset aakkoset
     */
    public final static OmaHash<Integer, Character> ENGLISH_INT_CHAR = new OmaHash<>();

    static {

        SUOMI_CHAR_INT.put('a', 0);
        SUOMI_CHAR_INT.put('b', 1);
        SUOMI_CHAR_INT.put('c', 2);
        SUOMI_CHAR_INT.put('d', 3);
        SUOMI_CHAR_INT.put('e', 4);
        SUOMI_CHAR_INT.put('f', 5);
        SUOMI_CHAR_INT.put('g', 6);
        SUOMI_CHAR_INT.put('h', 7);
        SUOMI_CHAR_INT.put('i', 8);
        SUOMI_CHAR_INT.put('j', 9);
        SUOMI_CHAR_INT.put('k', 10);
        SUOMI_CHAR_INT.put('l', 11);
        SUOMI_CHAR_INT.put('m', 12);
        SUOMI_CHAR_INT.put('n', 13);
        SUOMI_CHAR_INT.put('o', 14);
        SUOMI_CHAR_INT.put('p', 15);
        SUOMI_CHAR_INT.put('q', 16);
        SUOMI_CHAR_INT.put('r', 17);
        SUOMI_CHAR_INT.put('s', 18);
        SUOMI_CHAR_INT.put('t', 19);
        SUOMI_CHAR_INT.put('u', 20);
        SUOMI_CHAR_INT.put('v', 21);
        SUOMI_CHAR_INT.put('w', 22);
        SUOMI_CHAR_INT.put('x', 23);
        SUOMI_CHAR_INT.put('y', 24);
        SUOMI_CHAR_INT.put('z', 25);
        SUOMI_CHAR_INT.put('å', 26);
        SUOMI_CHAR_INT.put('ä', 27);
        SUOMI_CHAR_INT.put('ö', 28);

        SUOMI_INT_CHAR.put(0, 'a');
        SUOMI_INT_CHAR.put(1, 'b');
        SUOMI_INT_CHAR.put(2, 'c');
        SUOMI_INT_CHAR.put(3, 'd');
        SUOMI_INT_CHAR.put(4, 'e');
        SUOMI_INT_CHAR.put(5, 'f');
        SUOMI_INT_CHAR.put(6, 'g');
        SUOMI_INT_CHAR.put(7, 'h');
        SUOMI_INT_CHAR.put(8, 'i');
        SUOMI_INT_CHAR.put(9, 'j');
        SUOMI_INT_CHAR.put(10, 'k');
        SUOMI_INT_CHAR.put(11, 'l');
        SUOMI_INT_CHAR.put(12, 'm');
        SUOMI_INT_CHAR.put(13, 'n');
        SUOMI_INT_CHAR.put(14, 'o');
        SUOMI_INT_CHAR.put(15, 'p');
        SUOMI_INT_CHAR.put(16, 'q');
        SUOMI_INT_CHAR.put(17, 'r');
        SUOMI_INT_CHAR.put(18, 's');
        SUOMI_INT_CHAR.put(19, 't');
        SUOMI_INT_CHAR.put(20, 'u');
        SUOMI_INT_CHAR.put(21, 'v');
        SUOMI_INT_CHAR.put(22, 'w');
        SUOMI_INT_CHAR.put(23, 'x');
        SUOMI_INT_CHAR.put(24, 'y');
        SUOMI_INT_CHAR.put(25, 'z');
        SUOMI_INT_CHAR.put(26, 'å');
        SUOMI_INT_CHAR.put(27, 'ä');
        SUOMI_INT_CHAR.put(28, 'ö');

        ENGLISH_CHAR_INT.put('a', 0);
        ENGLISH_CHAR_INT.put('b', 1);
        ENGLISH_CHAR_INT.put('c', 2);
        ENGLISH_CHAR_INT.put('d', 3);
        ENGLISH_CHAR_INT.put('e', 4);
        ENGLISH_CHAR_INT.put('f', 5);
        ENGLISH_CHAR_INT.put('g', 6);
        ENGLISH_CHAR_INT.put('h', 7);
        ENGLISH_CHAR_INT.put('i', 8);
        ENGLISH_CHAR_INT.put('j', 9);
        ENGLISH_CHAR_INT.put('k', 10);
        ENGLISH_CHAR_INT.put('l', 11);
        ENGLISH_CHAR_INT.put('m', 12);
        ENGLISH_CHAR_INT.put('n', 13);
        ENGLISH_CHAR_INT.put('o', 14);
        ENGLISH_CHAR_INT.put('p', 15);
        ENGLISH_CHAR_INT.put('q', 16);
        ENGLISH_CHAR_INT.put('r', 17);
        ENGLISH_CHAR_INT.put('s', 18);
        ENGLISH_CHAR_INT.put('t', 19);
        ENGLISH_CHAR_INT.put('u', 20);
        ENGLISH_CHAR_INT.put('v', 21);
        ENGLISH_CHAR_INT.put('w', 22);
        ENGLISH_CHAR_INT.put('x', 23);
        ENGLISH_CHAR_INT.put('y', 24);
        ENGLISH_CHAR_INT.put('z', 25);
        ENGLISH_CHAR_INT.put('å', 26);
        ENGLISH_CHAR_INT.put('ä', 27);
        ENGLISH_CHAR_INT.put('ö', 28);

        ENGLISH_INT_CHAR.put(0, 'a');
        ENGLISH_INT_CHAR.put(1, 'b');
        ENGLISH_INT_CHAR.put(2, 'c');
        ENGLISH_INT_CHAR.put(3, 'd');
        ENGLISH_INT_CHAR.put(4, 'e');
        ENGLISH_INT_CHAR.put(5, 'f');
        ENGLISH_INT_CHAR.put(6, 'g');
        ENGLISH_INT_CHAR.put(7, 'h');
        ENGLISH_INT_CHAR.put(8, 'i');
        ENGLISH_INT_CHAR.put(9, 'j');
        ENGLISH_INT_CHAR.put(10, 'k');
        ENGLISH_INT_CHAR.put(11, 'l');
        ENGLISH_INT_CHAR.put(12, 'm');
        ENGLISH_INT_CHAR.put(13, 'n');
        ENGLISH_INT_CHAR.put(14, 'o');
        ENGLISH_INT_CHAR.put(15, 'p');
        ENGLISH_INT_CHAR.put(16, 'q');
        ENGLISH_INT_CHAR.put(17, 'r');
        ENGLISH_INT_CHAR.put(18, 's');
        ENGLISH_INT_CHAR.put(19, 't');
        ENGLISH_INT_CHAR.put(20, 'u');
        ENGLISH_INT_CHAR.put(21, 'v');
        ENGLISH_INT_CHAR.put(22, 'w');
        ENGLISH_INT_CHAR.put(23, 'x');
        ENGLISH_INT_CHAR.put(24, 'y');
        ENGLISH_INT_CHAR.put(25, 'z');
        ENGLISH_INT_CHAR.put(26, 'å');
        ENGLISH_INT_CHAR.put(27, 'ä');
        ENGLISH_INT_CHAR.put(28, 'ö');
    }

}
