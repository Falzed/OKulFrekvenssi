package tiralabra.okulfrekvenssi;

import java.util.HashMap;

/**
 *
 * @author Oskari
 */
public class Caesar {

    private HashMap<Integer, Character> hash;
    private HashMap<Character, Integer> hash2;

    /**
     *
     */
    public Caesar() {
        this.hash = new HashMap();
        this.hash.put(1, 'a');
        this.hash.put(2, 'b');
        this.hash.put(3, 'c');
        this.hash.put(4, 'd');
        this.hash.put(5, 'e');
        this.hash.put(6, 'f');
        this.hash.put(7, 'g');
        this.hash.put(8, 'h');
        this.hash.put(9, 'i');
        this.hash.put(10, 'j');
        this.hash.put(11, 'k');
        this.hash.put(12, 'l');
        this.hash.put(13, 'm');
        this.hash.put(14, 'n');
        this.hash.put(15, 'o');
        this.hash.put(16, 'p');
        this.hash.put(17, 'q');
        this.hash.put(18, 'r');
        this.hash.put(19, 's');
        this.hash.put(20, 't');
        this.hash.put(21, 'u');
        this.hash.put(22, 'v');
        this.hash.put(23, 'w');
        this.hash.put(24, 'x');
        this.hash.put(25, 'y');
        this.hash.put(26, 'z');
        this.hash.put(27, 'å');
        this.hash.put(28, 'ä');
        this.hash.put(29, 'ö');
        
        this.hash2 = new HashMap<>();
        this.hash2.put('a', 1);
        this.hash2.put('b', 2);
        this.hash2.put('c', 3);
        this.hash2.put('d', 4);
        this.hash2.put('e', 5);
        this.hash2.put('f', 6);
        this.hash2.put('g', 7);
        this.hash2.put('h', 8);
        this.hash2.put('i', 9);
        this.hash2.put('j', 10);
        this.hash2.put('k', 11);
        this.hash2.put('l', 12);
        this.hash2.put('m', 13);
        this.hash2.put('n', 14);
        this.hash2.put('o', 15);
        this.hash2.put('p', 16);
        this.hash2.put('q', 17);
        this.hash2.put('r', 18);
        this.hash2.put('s', 19);
        this.hash2.put('t', 20);
        this.hash2.put('u', 21);
        this.hash2.put('v', 22);
        this.hash2.put('w', 23);
        this.hash2.put('x', 24);
        this.hash2.put('y', 25);
        this.hash2.put('z', 26);
        this.hash2.put('å', 27);
        this.hash2.put('ä', 28);
        this.hash2.put('ö', 29);
    }

    /**
     *
     * @param plain salattava teksti
     * @param offset kuinka monta merkkiä mennään aakkosia eteenpäin
     * @return salattu teksti
     */
    public String encrypt(String plain, int offset) {
        String crypted = "";
        for(char c:plain.toCharArray()) {
//            System.out.println(hash.get((hash2.get(c)+offset)%29));
            crypted = crypted.concat(hash.get((hash2.get(c)+offset)%29).toString());
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
        for(char c:crypted.toCharArray()) {
//            System.out.println(hash.get((hash2.get(c)+offset)%29));
            plain = plain.concat(hash.get((hash2.get(c)-offset)%29).toString());
        }
        return plain;
    }
}
