package tiralabra.okulfrekvenssi.Ciphers;

import tiralabra.okulfrekvenssi.util.Alphabet;
import tiralabra.okulfrekvenssi.util.OmaHash;

/**
 * Lisätietoa: http://rumkin.com/tools/cipher/vigenere-keyed.php
 *
 * @author Oskari
 */
public class KeyedVigenere {

    private final char[][] keytable;
    private final char[][] capsKeytable;
    private final char[] alphabet;
    private final char[] capsAlphabet;
    private final OmaHash<Integer, Character> hash;
    private final OmaHash<Character, Integer> hash2;
    private final OmaHash<Integer, Character> capsHash;
    private final OmaHash<Character, Integer> capsHash2;

    /**
     *
     * @param key avain
     */
    public KeyedVigenere(String key) {

        String abc = new String(Alphabet.SUOMI);
        String ABC = new String(Alphabet.SUOMI_CAPS);
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
//        System.out.println(abc);
        ABC = Alphabet.removeAll(ABC, uusiAvainString.toUpperCase());
//        for (int i = 0; i < uusiAvainString.length(); i++) {
//            abc = abc.replaceAll(uusiAvainString.substring(i, i + 1), "");
//            ABC = ABC.replaceAll(uusiAvainString.toUpperCase().substring(i, i + 1), "");
//        }
        abc = uusiAvainString.concat(abc);
        ABC = uusiAvainString.toUpperCase().concat(ABC);
//        System.out.println(abc);
        this.hash = new OmaHash<>();
        this.hash2 = new OmaHash<>();
        this.capsHash = new OmaHash<>();
        this.capsHash2 = new OmaHash<>();
        for (int i = 0; i < abc.length(); i++) {
            hash.put(i, abc.charAt(i));
            capsHash.put(i, ABC.charAt(i));
            hash2.put(abc.charAt(i), i);
            capsHash2.put(ABC.charAt(i), i);
        }
        this.alphabet = abc.toCharArray();
        this.capsAlphabet = ABC.toCharArray();
        this.keytable = new char[abc.length()][abc.length()];
        this.capsKeytable = new char[abc.length()][abc.length()];
        for (int i = 0; i < alphabet.length; i++) {
            this.keytable[i] = abc.substring(i).concat(abc.substring(0, i))
                    .toCharArray();
            this.capsKeytable[i] = ABC.substring(i).concat(ABC.substring(0, i))
                    .toCharArray(); 
        }
    }

    /**
     * Alustaa luokan olion avaimena tyhjä merkkijono
     */
    public KeyedVigenere() {
        this.hash = Alphabet.SUOMI_INT_CHAR;
        this.hash2 = Alphabet.SUOMI_CHAR_INT;
        this.capsHash = Alphabet.SUOMI_CAPS_INT_CHAR;
        this.capsHash2 = Alphabet.SUOMI_CAPS_CHAR_INT;
        this.alphabet = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z', 'å', 'ä', 'ö'};
        this.capsAlphabet = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
            'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
            'W', 'X', 'Y', 'Z', 'Å', 'Ä', 'Ö'};

        String abc = "abcdefghijklmnopqrstuvwxyzåäö";
        String ABC = "ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ";
        this.keytable = new char[alphabet.length][alphabet.length];
        this.capsKeytable = new char[alphabet.length][alphabet.length];
        for (int i = 0; i < alphabet.length; i++) {
            this.keytable[i] = abc.substring(i).concat(abc.substring(0, i))
                    .toCharArray();
            this.capsKeytable[i] = ABC.substring(i).concat(ABC.substring(0, i))
                    .toCharArray();
        }
    }

    /**
     *
     * @return avaintaulukko
     */
    public char[][] getKeytable() {
        return this.keytable;
    }

    /**
     * Salaa annetun viestin annetulla avaimella
     * @param message salattava viesti
     * @param passphrase avain
     * @return salattu teksti
     */
    public String encrypt(String message, String passphrase) {
        passphrase = passphrase.toLowerCase();
        String pass = passphrase;
        while (pass.length() + passphrase.length() < message.length()) {
            pass = pass + passphrase;
        }
        pass = pass + passphrase.substring(0, message.length() - pass.length());

//        System.out.println(pass);
        char[] mess = message.toCharArray();
        char[] ciphertext = new char[mess.length];
        for (int i = 0; i < mess.length; i++) {
            if (Alphabet.isFinnishLetter(mess[i])) {
                int messCharIndex = this.hash2.get(mess[i]);
//            int messCharIndex = indexOf(mess[i], this.alphabet);
//            System.out.println(mess[i]);
//            System.out.println(this.hash2.get(mess[i]));
//            System.out.println(indexOf(mess[i], this.alphabet));
//            System.out.println(this.hash2.get(mess[i])==indexOf(mess[i], this.alphabet));
                int row = this.hash2.get(pass.charAt(i));
//            System.out.println(this.hash2.get(pass.charAt(i)));
//            System.out.println(indexOf(pass.charAt(i), this.alphabet));
//            System.out.println(this.hash2.get(pass.charAt(i))==indexOf(pass.charAt(i), this.alphabet));
//            int row = indexOf(pass.charAt(i), this.alphabet);
//            System.out.println(row+", "+messCharIndex);
                ciphertext[i] = this.keytable[row][messCharIndex];
            } else if (Alphabet.isCapitalFinnishLetter(mess[i])) {
//                System.out.println(mess[i]);
                int messCharIndex = this.capsHash2.get(mess[i]);
                int row = hash2.get(pass.charAt(i));
                ciphertext[i] = this.capsKeytable[row][messCharIndex];
//                System.out.println(ciphertext[i]);
            } else {
                ciphertext[i] = mess[i];
            }

        }

        return new String(ciphertext);
    }

    /**
     * Purkaa salauksen annetusta salatusta tekstistä annetulla avaimella
     * @param crypted salattu teksti
     * @param passphrase avain
     * @return paljas teksti
     */
    public String decrypt(String crypted, String passphrase) {
        passphrase = passphrase.toLowerCase();
        String pass = passphrase;
        while (pass.length() + passphrase.length() < crypted.length()) {
            pass = pass + passphrase;
        }
//        System.out.println(crypted);
//        System.out.println(pass);
        pass = pass + passphrase.substring(0, crypted.length() - pass.length());

        char[] crypt = crypted.toCharArray();
        char[] plaintext = new char[crypt.length];

        for (int i = 0; i < crypt.length; i++) {
//            int row = indexOf(pass.charAt(i), this.alphabet);
            char c = pass.charAt(i);
            if (Alphabet.isFinnishLetter(crypt[i])) {
                int row = hash2.get(c);
//                System.out.println(crypt[i]);
                int indeksi = (hash2.get(crypt[i]) - row + 29) % alphabet.length;
                char plain = alphabet[indeksi];
                plaintext[i] = plain;
            } else if (Alphabet.isCapitalFinnishLetter(crypt[i])) {
                int row = hash2.get(c);
                int indeksi = (capsHash2.get(crypt[i]) - row + 29) % alphabet.length;
                char plain = capsAlphabet[indeksi];
                plaintext[i] = plain;
            } else {
                plaintext[i] = crypt[i];
            }
        }
        return new String(plaintext);
    }

}
