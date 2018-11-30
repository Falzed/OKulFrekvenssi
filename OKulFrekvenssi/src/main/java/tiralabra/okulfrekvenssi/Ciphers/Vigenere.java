package tiralabra.okulfrekvenssi.Ciphers;

import tiralabra.okulfrekvenssi.util.Alphabet;
import tiralabra.okulfrekvenssi.util.OmaHash;

/**
 * Lisätietoa: http://rumkin.com/tools/cipher/vigenere.php
 *
 * @author Oskari
 */
public class Vigenere {

    private final char[][] keytable;
    private final char[][] capsKeytable;
    private final char[] alphabet;
    private final char[] capsAlphabet;
    private final OmaHash<Integer, Character> hash = Alphabet.SUOMI_INT_CHAR;
    private final OmaHash<Character, Integer> hash2 = Alphabet.SUOMI_CHAR_INT;
    private final OmaHash<Character, Integer> capsHash2 = Alphabet.SUOMI_CAPS_CHAR_INT;

    /**
     * Alustaa luokan olion
     */
    public Vigenere() {
//        String passphrase = pass.toLowerCase();
        //Korvaa kotitekoisella hashmapilla myöhemmin
        this.alphabet = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z', 'å', 'ä', 'ö'};
        this.capsAlphabet = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
            'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
            'W', 'X', 'Y', 'Z', 'Å', 'Ä', 'Ö'};
//        this.alphabet = "abcdefghijklmnopqrstuvwxyzåäö";

//        this.keytable = new char[alphabet.length][passphrase.length()];
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

//        for (int i = 0; i < alphabet.length; i++) {
//            for (int j = 0; j < passphrase.length(); j++) {
//                int k = i+indexOf(passphrase.toCharArray()[j],alphabet)-1;
//                System.out.println("i:"+i+", j:"+j);
//                System.out.println("k:"+k);
//                System.out.println("k%alphabet.length:"+k%alphabet.length);
//                keytable[i][j] = alphabet[k%alphabet.length];
//            }
//        }
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
        passphrase = passphrase.toLowerCase();
        String pass = passphrase;
        while (pass.length() + passphrase.length() < message.length()) {
            pass = pass + passphrase;
        }
        pass = pass + passphrase.substring(0, message.length() - pass.length());
        char[] mess = message.toCharArray();
        char[] ciphertext = new char[mess.length];
        int notLetterCount = 0;
        for (int i = 0; i < mess.length; i++) {
            if (Alphabet.isFinnishLetter(mess[i])) {
                int messCharIndex = this.hash2.get(mess[i]);
                int row = this.hash2.get(pass.charAt(i - notLetterCount));
                ciphertext[i] = this.keytable[row][messCharIndex];
            } else if (Alphabet.isCapitalFinnishLetter(mess[i])) {
                int messCharIndex = Alphabet.SUOMI_CAPS_CHAR_INT.get(mess[i]);
                int row = hash2.get(pass.charAt(i - notLetterCount));
                ciphertext[i] = this.capsKeytable[row][messCharIndex];
            } else {
                ciphertext[i] = mess[i];
                notLetterCount++;
            }
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

        int notLetterCount = 0;
        for (int i = 0; i < crypt.length; i++) {
//            int row = indexOf(pass.charAt(i), this.alphabet);
            char c = pass.charAt(i-notLetterCount);
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
                notLetterCount++;
            }
        }
        return new String(plaintext);
    }
}
