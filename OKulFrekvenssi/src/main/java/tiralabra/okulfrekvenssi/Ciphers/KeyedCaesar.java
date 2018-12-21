/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.okulfrekvenssi.Ciphers;

import java.util.Arrays;
import tiralabra.okulfrekvenssi.util.Alphabet;
import tiralabra.okulfrekvenssi.util.OmaHash;

/**
 * Lisätietoa: http://rumkin.com/tools/cipher/caesar-keyed.php
 *
 * @author Oskari
 */
public class KeyedCaesar {

    private final OmaHash<Integer, Character> hashIntChar;
    private final OmaHash<Character, Integer> hashCharInt;
    private final String aakkosto;

    /**
     * Alustaa luokan olion annetulla avaimella
     *
     * @param key avain
     */
    public KeyedCaesar(String key) {
        String abc = new String(Alphabet.ENGLISH);
        char[] newKey = new char[key.length()];
        int n = 0;
        OmaHash<Character, Integer> apuhash = new OmaHash<>();
        for (int i = 0; i < key.length(); i++) {
            if (apuhash.get(key.charAt(i)) == null) {
                newKey[n] = key.charAt(i);
                n++;
                apuhash.put(key.charAt(i), 1);
            }
        }
        String uusiAvainString = (new String(newKey)).substring(0, n);
        abc = Alphabet.removeAll(abc, uusiAvainString);
        abc = uusiAvainString.concat(abc);
        this.hashCharInt = new OmaHash<>();
        this.hashIntChar = new OmaHash<>();
        for (int i = 0; i < abc.length(); i++) {
            hashIntChar.put(i, abc.charAt(i));
            hashCharInt.put(abc.charAt(i), i);
        }
        this.aakkosto = abc;
    }

    /**
     * Alustaa luokan olion avaimena tyhjä merkkijono
     */
    public KeyedCaesar() {
        this.hashIntChar = Alphabet.ENGLISH_INT_CHAR;
        this.hashCharInt = Alphabet.ENGLISH_CHAR_INT;
        this.aakkosto = new String(Alphabet.ENGLISH);
    }

    /**
     *
     * @param plain salattava teksti
     * @param offset kuinka monta merkkiä mennään aakkosia eteenpäin
     * @return salattu teksti
     */
    public String encrypt(String plain, int offset) {
        char[] crypted = new char[plain.length()];
        int i = 0;
        for (char c : plain.toCharArray()) {
            if (Alphabet.isLetter(c, this.aakkosto.toCharArray())) {
                crypted[i] = hashIntChar.get((Alphabet.ENGLISH_CHAR_INT.get(c) + offset) % aakkosto.length());
            } else if (Alphabet.isLetter(c, aakkosto.toUpperCase().toCharArray())) {
                crypted[i] = Alphabet.ENGLISH_CAPS_INT_CHAR.get((Alphabet.ENGLISH_CAPS_CHAR_INT.get(c) + offset) % aakkosto.length());
            } else {
                crypted[i] = c;
            }
            i++;
        }
        return new String(crypted);
    }

    /**
     *
     * @param crypted salattu teksti
     * @param offset kuinka monta merkkiä mennään aakkosia eteenpäin salatessa
     * @return salaamaton teksti
     */
    public String decrypt(String crypted, int offset) {
        char[] plain = new char[crypted.length()];
        int i = 0;
        for (char c : crypted.toCharArray()) {
            if (Alphabet.isLetter(c, aakkosto.toCharArray())) {
                plain[i] = Alphabet.ENGLISH_INT_CHAR.get((hashCharInt.get(c) - offset + aakkosto.length())
                        % aakkosto.length());
            } else if (Alphabet.isLetter(c, aakkosto.toUpperCase().toCharArray())) {
                plain[i]
                        = Alphabet.ENGLISH_CAPS_INT_CHAR.get(
                                (Alphabet.ENGLISH_CAPS_CHAR_INT.get(c)
                                - offset + aakkosto.length())
                                % aakkosto.length());

            } else {
                plain[i] = c;
            }
            i++;
        }
        return new String(plain);
    }
}
