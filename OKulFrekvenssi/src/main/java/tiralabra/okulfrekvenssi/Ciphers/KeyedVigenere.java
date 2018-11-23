package tiralabra.okulfrekvenssi.Ciphers;

import tiralabra.okulfrekvenssi.util.Alphabet;
import tiralabra.okulfrekvenssi.util.OmaHash;

/**
 * Lisätietoa: http://rumkin.com/tools/cipher/vigenere-keyed.php
 * @author Oskari
 */
public class KeyedVigenere {

    private final char[][] keytable;
    private final char[] alphabet;
    private final OmaHash<Integer, Character> hash;
    private final OmaHash<Character, Integer> hash2;
    
    /**
     * 
     * @param key avain
     */
    public KeyedVigenere(String key) {

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
        this.hash = new OmaHash<>();
        this.hash2 = new OmaHash<>();
        for (int i = 0; i < abc.length(); i++) {
            hash.put(i, abc.charAt(i));
            hash2.put(abc.charAt(i), i);
        }
        this.alphabet = abc.toCharArray();
        this.keytable = new char[abc.length()][abc.length()];
        for (int i = 0; i < alphabet.length; i++) {
            this.keytable[i] = abc.substring(i).concat(abc.substring(0, i))
                    .toCharArray();
        }
    }

    /**
     *
     */
    public KeyedVigenere() {
        this.hash = Alphabet.SUOMI_INT_CHAR;
        this.hash2 = Alphabet.SUOMI_CHAR_INT;
        this.alphabet = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z', 'å', 'ä', 'ö'};

        String abc = "abcdefghijklmnopqrstuvwxyzåäö";
        this.keytable = new char[alphabet.length][alphabet.length];
        for (int i = 0; i < alphabet.length; i++) {
            this.keytable[i] = abc.substring(i).concat(abc.substring(0, i))
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
     *
     * @param message salattava viesti
     * @param passphrase avain
     * @return salattu teksti
     */
    public String encrypt(String message, String passphrase) {
        message = message.toLowerCase();
        message = message.replaceAll("[^a-zåäö]", "");
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
            int messCharIndex = this.hash2.get(mess[i]);
//            int messCharIndex = indexOf(mess[i], this.alphabet);
            
            int row = this.hash2.get(pass.charAt(i));
            
//            int row = indexOf(pass.charAt(i), this.alphabet);
            System.out.println(row+", "+messCharIndex+", "+this.keytable[row][messCharIndex]);
            ciphertext[i] = this.keytable[row][messCharIndex];
        }

        return new String(ciphertext);
    }

    /**
     *
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
            int row = hash2.get(pass.charAt(i));
//            int indeksi = indexOf(crypt[i], this.keytable[row]);
            int indeksi = (hash2.get(crypt[i]) - row + 29) % alphabet.length;
            char plain = alphabet[indeksi];
            plaintext[i] = plain;
        }
        return new String(plaintext);
    }
}
