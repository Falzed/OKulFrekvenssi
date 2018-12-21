package tiralabra.okulfrekvenssi.Ciphers;

import tiralabra.okulfrekvenssi.util.Alphabet;
import tiralabra.okulfrekvenssi.util.OmaHash;

/**
 * Lisätietoa: http://rumkin.com/tools/cipher/caesar.php
 *
 * @author Oskari
 */
public class Caesar {

    /**
     *
     * @param plain salattava teksti
     * @param offset kuinka monta merkkiä mennään aakkosia eteenpäin
     * @return salattu teksti
     */
    public String encrypt(String plain, int offset, char[] alphabet) {
        String crypted = "";
        char[] capsAlphabet = new String(alphabet).toUpperCase().toCharArray();
        OmaHash<Character, Integer> charInt = Alphabet.createCharIntHash(alphabet);
        OmaHash<Integer, Character> intChar = Alphabet.createIntCharHash(alphabet);
        OmaHash<Character, Integer> charIntCaps = Alphabet.createCharIntHash(capsAlphabet);
        OmaHash<Integer, Character> intCharCaps = Alphabet.createIntCharHash(capsAlphabet);
        for (char c : plain.toCharArray()) {
            if (Alphabet.isFinnishLetter(c)) {
                crypted = crypted.concat(intChar.get((charInt.get(c) + offset) % alphabet.length).toString());
            } else if (Alphabet.isCapitalFinnishLetter(c)) {
                crypted = crypted.concat(intCharCaps.get((charIntCaps.get(c) + offset) % alphabet.length).toString());
            } else {
                crypted = crypted.concat(String.valueOf(c));
            }
        }
        return crypted;
    }

    /**
     *
     * @param crypted salattu teksti
     * @param offset kuinka monta merkkiä mennään aakkosia eteenpäin salatessa
     * @return salaamaton teksti
     */
    public String decrypt(String crypted, int offset, char[] alphabet) {
        String plain = "";
        char[] capsAlphabet = new String(alphabet).toUpperCase().toCharArray();
        OmaHash<Character, Integer> charInt = Alphabet.createCharIntHash(alphabet);
        OmaHash<Integer, Character> intChar = Alphabet.createIntCharHash(alphabet);
        OmaHash<Character, Integer> charIntCaps = Alphabet.createCharIntHash(capsAlphabet);
        OmaHash<Integer, Character> intCharCaps = Alphabet.createIntCharHash(capsAlphabet);
        
        for (char c : crypted.toCharArray()) {
            if (Alphabet.isFinnishLetter(c)) {
//                System.out.println(c);
                plain = plain.concat(intChar.get((charInt.get(c) - offset + alphabet.length) % alphabet.length).toString());
            } else if (Alphabet.isCapitalFinnishLetter(c)) {
//                System.out.println(c);
                plain = plain.concat(intCharCaps.get((charIntCaps.get(c) - offset + alphabet.length) % alphabet.length).toString());
            } else {
                plain = plain.concat(String.valueOf(c));
            }
        }
        return plain;
    }
}
