package tiralabra.okulfrekvenssi.Ciphers;

import tiralabra.okulfrekvenssi.util.Alphabet;
import tiralabra.okulfrekvenssi.util.OmaHash;

/**
 * Lisätietoa:  http://rumkin.com/tools/cipher/vigenere.php
 * @author Oskari
 */
public class Vigenere {

    private final char[][] keytable;
    private final char[] alphabet;
    private final OmaHash<Integer, Character> hash = Alphabet.SUOMI_INT_CHAR;
    private final OmaHash<Character, Integer> hash2 = Alphabet.SUOMI_CHAR_INT;

    /**
     *
     */
    public Vigenere() {
//        String passphrase = pass.toLowerCase();
        //Korvaa kotitekoisella hashmapilla myöhemmin
        this.alphabet = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z', 'å', 'ä', 'ö'};
//        this.alphabet = "abcdefghijklmnopqrstuvwxyzåäö";

//        this.keytable = new char[alphabet.length][passphrase.length()];
        String abc = "abcdefghijklmnopqrstuvwxyzåäö";
        this.keytable = new char[alphabet.length][alphabet.length];
        for (int i = 0; i < alphabet.length; i++) {
            this.keytable[i] = abc.substring(i).concat(abc.substring(0, i))
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

    //Korvaa myöhemmin kotitekoisella hashmapilla
    /**
     * @param etsittava etsittävä merkki
     * @param taulu taulu jossa etsitään
     * @return ensimmäisen täsmäävän taulukon jäsenen indeksi
     */
    private int indexOf(char etsittava, char[] taulu) {
//        System.out.println("etsittava: "+etsittava);
        for (int i = 0; i < taulu.length; i++) {
            if (taulu[i] == etsittava) {
                return i;
            }
        }
        return -1;
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
        crypted = crypted.toLowerCase();
        crypted = crypted.replaceAll("[^a-zåäö]", "");
        
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
            int indeksi = (hash2.get(crypt[i])-row+29)%alphabet.length;
            char plain = alphabet[indeksi];
            plaintext[i] = plain;
        }
        return new String(plaintext);
    }
}
