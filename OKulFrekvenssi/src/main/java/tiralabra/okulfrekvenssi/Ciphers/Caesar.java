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
    public String encrypt(String plain, int offset) {
        String crypted = "";
        for (char c : plain.toCharArray()) {
//            System.out.println(hash.get((hash2.get(c)+offset)%29));
            if (Alphabet.isFinnishLetter(c)) {
                crypted = crypted.concat(Alphabet.SUOMI_INT_CHAR.get((Alphabet.SUOMI_CHAR_INT.get(c) + offset) % 29).toString());
            } else if (Alphabet.isCapitalFinnishLetter(c)) {
                crypted = crypted.concat(Alphabet.SUOMI_CAPS_INT_CHAR.get((Alphabet.SUOMI_CAPS_CHAR_INT.get(c) + offset) % 29).toString());
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
    public String decrypt(String crypted, int offset) {
        String plain = "";
        for (char c : crypted.toCharArray()) {
//            System.out.println(c);
//            System.out.println(hash2.get(c));
//            System.out.println(hash.get(hash2.get(c)));
//            System.out.println(c+", "+hash2.get(c)+", "+hash.get(hash2.get(c))+", "+(hash2.get(c)-offset+29)%29);
            if (Alphabet.isFinnishLetter(c)) {
//                System.out.println(c);
                plain = plain.concat(Alphabet.SUOMI_INT_CHAR.get((Alphabet.SUOMI_CHAR_INT.get(c) - offset + 29) % 29).toString());
            } else if (Alphabet.isCapitalFinnishLetter(c)) {
//                System.out.println(c);
//                System.out.println(Alphabet.SUOMI_CAPS_CHAR_INT.get(c));
//                System.out.println(Alphabet.SUOMI_CAPS_CHAR_INT.get(c));
                plain = plain.concat(Alphabet.SUOMI_CAPS_INT_CHAR.get((Alphabet.SUOMI_CAPS_CHAR_INT.get(c) - offset + 29) % 29).toString());
            } else {
                plain = plain.concat(String.valueOf(c));
            }
        }
        return plain;
    }
}
