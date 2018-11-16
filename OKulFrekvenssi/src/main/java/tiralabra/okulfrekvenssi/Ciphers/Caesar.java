package tiralabra.okulfrekvenssi.Ciphers;

import tiralabra.okulfrekvenssi.util.Alphabet;
import tiralabra.okulfrekvenssi.util.OmaHash;

/**
 *
 * @author Oskari
 */
public class Caesar {

    private final OmaHash<Integer, Character> hash = Alphabet.SUOMI_INT_CHAR;
    private final OmaHash<Character, Integer> hash2 = Alphabet.SUOMI_CHAR_INT;

    /**
     *
     */
    public Caesar() {
    }

    /**
     *
     * @param plain salattava teksti
     * @param offset kuinka monta merkkiä mennään aakkosia eteenpäin
     * @return salattu teksti
     */
    public String encrypt(String plain, int offset) {
        plain = plain.toLowerCase();
        plain = plain.replaceAll("[^a-z]", "");
        String crypted = "";
        for (char c : plain.toCharArray()) {
//            System.out.println(hash.get((hash2.get(c)+offset)%29));
            crypted = crypted.concat(hash.get((hash2.get(c) + offset) % 29).toString());
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
        crypted = crypted.replaceAll("[^a-z]", "");
        String plain = "";
        for (char c : crypted.toCharArray()) {
//            System.out.println(c);
//            System.out.println(hash2.get(c));
//            System.out.println(hash.get(hash2.get(c)));
//            System.out.println(c+", "+hash2.get(c)+", "+hash.get(hash2.get(c))+", "+(hash2.get(c)-offset+29)%29);
            plain = plain.concat(hash.get((hash2.get(c) - offset + 29) % 29).toString());
        }
        return plain;
    }
}
