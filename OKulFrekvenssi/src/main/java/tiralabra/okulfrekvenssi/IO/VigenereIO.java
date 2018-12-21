/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.okulfrekvenssi.IO;

import java.util.Scanner;
import tiralabra.okulfrekvenssi.Analyysi.Analysis;
import tiralabra.okulfrekvenssi.Analyysi.VigenereAnalysis;
import tiralabra.okulfrekvenssi.Ciphers.KeyedVigenere;
import tiralabra.okulfrekvenssi.Ciphers.Vigenere;
import tiralabra.okulfrekvenssi.util.Alphabet;

/**
 *
 * @author Oskari
 */
public class VigenereIO {

    /**
     *
     * @param scanner käytetty Scanner
     */
    public static void vigenere(Scanner scanner) {
        System.out.println("encrypt or decrypt");
        String line3 = scanner.nextLine();
        switch (line3) {
            case "encrypt": {
                System.out.println("enter plaintext");
                String plain = scanner.nextLine();
                System.out.println("enter passphrase");
                String passphrase = scanner.nextLine();
                Vigenere vigenere = new Vigenere(Alphabet.ENGLISH);
                System.out.println(vigenere.encrypt(plain, passphrase));
                break;
            }
            case "decrypt": {
                System.out.println("enter ciphertext");
                String cipher = scanner.nextLine();
                System.out.println("enter passphrase (empty string for unknown)");
                String passphrase = scanner.nextLine();
                if (passphrase.equals("")) {
                    String guess = VigenereAnalysis.bestGuess(cipher, Alphabet.ENGLISH);
                    System.out.println(guess);
                } else {
                    Vigenere vigenere = new Vigenere(Alphabet.ENGLISH);
                    System.out.println(vigenere.decrypt(cipher, passphrase));
                }
                break;
            }
            default:
                System.out.println("command unrecognized");
                break;
        }
    }
}
