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
     * Salaa annetun tekstin
     *
     * @param plain salattava teksti
     * @param offset kuinka monta merkkiä mennään aakkosia eteenpäin
     * @param alphabet käytetty aakkosto
     * @return salattu teksti
     */
    public String encrypt(String plain, int offset, char[] alphabet) {
        char[] crypted = new char[plain.length()];
        char[] capsAlphabet = new String(alphabet).toUpperCase().toCharArray();
        OmaHash<Character, Integer> charInt = Alphabet.createCharIntHash(alphabet);
        OmaHash<Integer, Character> intChar = Alphabet.createIntCharHash(alphabet);
        OmaHash<Character, Integer> charIntCaps = Alphabet.createCharIntHash(capsAlphabet);
        OmaHash<Integer, Character> intCharCaps = Alphabet.createIntCharHash(capsAlphabet);
        int i = 0;
        for (char c : plain.toCharArray()) {
            if (Alphabet.isLetter(c, alphabet)) {
                crypted[i] = intChar.get((charInt.get(c) + offset) % alphabet.length);
            } else if (Alphabet.isLetter(c, capsAlphabet)) {
                crypted[i] = intCharCaps.get((charIntCaps.get(c) + offset) % alphabet.length);
            } else {
                crypted[i] = c;
            }
            i++;
        }
        return new String (crypted);
    }

    /**
     * Purkaa annetun tekstin salauksen
     *
     * @param crypted salattu teksti
     * @param offset kuinka monta merkkiä mennään aakkosia eteenpäin salatessa
     * @param alphabet käytetty aakkosto
     * @return salaamaton teksti
     */
    public String decrypt(String crypted, int offset, char[] alphabet) {
        char[] plain = new char[crypted.length()];
        char[] capsAlphabet = new String(alphabet).toUpperCase().toCharArray();
        OmaHash<Character, Integer> charInt = Alphabet.createCharIntHash(alphabet);
        OmaHash<Integer, Character> intChar = Alphabet.createIntCharHash(alphabet);
        OmaHash<Character, Integer> charIntCaps = Alphabet.createCharIntHash(capsAlphabet);
        OmaHash<Integer, Character> intCharCaps = Alphabet.createIntCharHash(capsAlphabet);

        int i=0;
        for (char c : crypted.toCharArray()) {
            if (Alphabet.isLetter(c, alphabet)) {
                plain[i] = intChar.get((charInt.get(c) - offset + alphabet.length) % alphabet.length);
            } else if (Alphabet.isLetter(c, capsAlphabet)) {
                plain[i] = intCharCaps.get((charIntCaps.get(c) - offset + alphabet.length) % alphabet.length);
            } else {
                plain[i] = c;
            }
            i++;
        }
        return new String(plain);
    }
}
