/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.okulfrekvenssi.Ciphers;

import tiralabra.okulfrekvenssi.util.Alphabet;
import tiralabra.okulfrekvenssi.util.OmaHash;

/**
 * Lisätietoa: http://rumkin.com/tools/cipher/caesar-keyed.php
 * @author Oskari
 */
public class KeyedCaesar {

    private final OmaHash<Integer, Character> hashIntChar;
    private final OmaHash<Character, Integer> hashCharInt;
    private final String aakkosto;

    /**
     *
     * @param key avain
     */
    public KeyedCaesar(String key) {
        String abc = new String(Alphabet.SUOMI);
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
        for (int i = 0; i < uusiAvainString.length(); i++) {
            abc = abc.replaceAll(uusiAvainString.substring(i, i + 1), "");
        }
        abc = uusiAvainString.concat(abc);
        System.out.println(abc);
        this.hashCharInt = new OmaHash<>();
        this.hashIntChar = new OmaHash<>();
        for (int i = 0; i < abc.length(); i++) {
            hashIntChar.put(i,abc.charAt(i));
            hashCharInt.put(abc.charAt(i), i);
        }
        this.aakkosto = abc;
    }

    /**
     *
     */
    public KeyedCaesar() {
        this.hashIntChar = Alphabet.SUOMI_INT_CHAR;
        this.hashCharInt = Alphabet.SUOMI_CHAR_INT;
        this.aakkosto = new String(Alphabet.SUOMI);
    }

    /**
     *
     * @param plain salattava teksti
     * @param offset kuinka monta merkkiä mennään aakkosia eteenpäin
     * @return salattu teksti
     */
    public String encrypt(String plain, int offset) {
        plain = plain.toLowerCase();
        plain = plain.replaceAll("[^a-zåäö]", "");
        String crypted = "";
        for (char c : plain.toCharArray()) {
            crypted = crypted.concat(hashIntChar.get((Alphabet.SUOMI_CHAR_INT.get(c) + offset) % aakkosto.length()).toString());
//            System.out.println("c:"+c+", hash2.get(c):"+hash2.get(c)+", hash.get((hash2.get(c) + offset):"+hash.get((hash2.get(c) + offset)));
//            System.out.println(crypted);
        }
        return crypted;
    }

    /**
     *
     * @param crypted salattu teksti
     * @param offset kuinka monta merkkiä mennään aakkosia eteenpäin salatessa
     * @return salaamaton teksti
     */
    public String decrypt(String crypted, int offset) {
        crypted = crypted.toLowerCase();
        crypted = crypted.replaceAll("[^a-zåäö]", "");
        String plain = "";
        for (char c : crypted.toCharArray()) {
//            System.out.println(c+", "+hashCharInt.get(c)+", "+Alphabet.SUOMI_INT_CHAR.get(hashCharInt.get(c))+", "+(hashCharInt.get(c)-offset+29)%29);
            plain = plain.concat(
                    Alphabet.SUOMI_INT_CHAR.get((hashCharInt.get(c) - offset + aakkosto.length())
                            % aakkosto.length()).toString());
        }
        return plain;
    }
}
