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

    private final OmaHash<Integer, Character> hash;
    private final OmaHash<Character, Integer> hash2;
    private final OmaHash<Character, Integer> capsHash2;

    /**
     * Alustaa luokan olion
     *
     * @param alphabet käytetty aakkosto
     */
    public Vigenere(char[] alphabet) {
        this.alphabet = alphabet;
        this.capsAlphabet = new String(alphabet).toUpperCase().toCharArray();
        this.keytable = new char[alphabet.length][alphabet.length];
        this.capsKeytable = new char[alphabet.length][alphabet.length];
        String abc = new String(alphabet);
        String ABC = new String(this.capsAlphabet);
        for (int i = 0; i < alphabet.length; i++) {
            this.keytable[i] = abc.substring(i).concat(abc.substring(0, i))
                    .toCharArray();
            this.capsKeytable[i] = ABC.substring(i).concat(ABC.substring(0, i))
                    .toCharArray();
        }

        this.hash = Alphabet.createIntCharHash(this.alphabet);
        this.hash2 = Alphabet.createCharIntHash(this.alphabet);
        this.capsHash2 = Alphabet.createCharIntHash(capsAlphabet);

    }

    /**
     *
     * @return avaintaulukko
     */
    public char[][] getKeytable() {
        return this.keytable;
    }

    /**
     * Salaa annetun tekstin
     *
     * @param message salattava viesti
     * @param passphrase avain
     * @return salattu teksti
     */
    public String encrypt(String message, String passphrase) {
        passphrase = passphrase.toLowerCase();
        char[] passphraseArray = passphrase.toCharArray();
        char[] passArray = new char[message.length()];
        for (int i = 0; i < message.length(); i++) {
            passArray[i] = passphraseArray[i % passphraseArray.length];
        }
//        String pass = passphrase;
//        while (pass.length() + passphrase.length() < message.length()) {
//            pass = pass + passphrase;
//        }
//        pass = pass + passphrase.substring(0, message.length() - pass.length());
        String pass = new String(passArray);
        char[] mess = message.toCharArray();
        char[] ciphertext = new char[mess.length];
        int notLetterCount = 0;
        for (int i = 0; i < mess.length; i++) {
            if (Alphabet.isLetter(mess[i], this.alphabet)) {
                int messCharIndex = this.hash2.get(mess[i]);
                int row = this.hash2.get(pass.charAt(i - notLetterCount));
                ciphertext[i] = this.keytable[row][messCharIndex];
            } else if (Alphabet.isLetter(mess[i], this.capsAlphabet)) {
                int messCharIndex = Alphabet.ENGLISH_CAPS_CHAR_INT.get(mess[i]);
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
        char[] passphraseArray = passphrase.toCharArray();
        char[] passArray = new char[crypted.length()];
        for (int i = 0; i < crypted.length(); i++) {
            passArray[i] = passphraseArray[i % passphraseArray.length];
        }
        String pass = new String(passArray);

//        passphrase = passphrase.toLowerCase();
//        String pass = passphrase;
//        while (pass.length() + passphrase.length() < crypted.length()) {
//            pass = pass + passphrase;
//        }
//        pass = pass + passphrase.substring(0, crypted.length() - pass.length());
        char[] crypt = crypted.toCharArray();
        char[] plaintext = new char[crypt.length];

        int notLetterCount = 0;
        for (int i = 0; i < crypt.length; i++) {
            char c = pass.charAt(i - notLetterCount);
            if (Alphabet.isLetter(crypt[i], this.alphabet)) {
                int row = hash2.get(c);
                int indeksi = (hash2.get(crypt[i]) - row + alphabet.length) % alphabet.length;
                char plain = alphabet[indeksi];
                plaintext[i] = plain;
            } else if (Alphabet.isLetter(crypt[i], this.capsAlphabet)) {
                int row = hash2.get(c);
                int indeksi = (capsHash2.get(crypt[i]) - row + alphabet.length) % alphabet.length;
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
