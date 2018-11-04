package tiralabra.okulfrekvenssi;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Vigenere {

    private char[][] keytable;
    private final char[] alphabet;
//    private final String alphabet;

    public Vigenere() {
//        String passphrase = pass.toLowerCase();
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

    private int indexOf(char etsittava, char[] taulu) {
//        System.out.println("etsittava: "+etsittava);
        for (int i = 0; i < taulu.length; i++) {
            if (taulu[i] == etsittava) {
                return i;
            }
        }
        return -1;
    }

    public char[][] getKeytable() {
        return this.keytable;
    }
    
    public String encrypt(String message, String passphrase) {
        message = message.toLowerCase();
        passphrase = passphrase.toLowerCase();
        String pass = passphrase; 
        while(pass.length()+passphrase.length()<message.length()) {
            pass = pass+passphrase;
        }
        pass = pass + passphrase.substring(0, message.length()-pass.length());
        
//        System.out.println(pass);
        
        char[] mess = message.toCharArray();
        char[] ciphertext = new char[mess.length];
        for(int i=0; i<mess.length; i++) {
            int messCharIndex = indexOf(mess[i], this.alphabet);
            int row = indexOf(pass.charAt(i), this.alphabet);
            System.out.println(row+", "+messCharIndex);
            ciphertext[i] = this.keytable[row][messCharIndex];
        }
        
        return new String(ciphertext);
    }
}
