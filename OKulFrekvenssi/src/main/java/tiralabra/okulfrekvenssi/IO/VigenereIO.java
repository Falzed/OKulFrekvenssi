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

/**
 *
 * @author Oskari
 */
public class VigenereIO {
    public static void vigenere(Scanner scanner) {
        System.out.println("encrypt or decrypt");
        String line3 = scanner.nextLine();
        switch (line3) {
            case "encrypt": {
                System.out.println("enter plaintext");
                String plain = scanner.nextLine();
                System.out.println("enter passphrase");
                String passphrase = scanner.nextLine();
                Vigenere vigenere = new Vigenere();
                System.out.println(vigenere.encrypt(plain, passphrase));
                break;
            }
            case "decrypt": {
                System.out.println("enter ciphertext");
                String cipher = scanner.nextLine();
                System.out.println("enter passphrase (empty string for unknown)");
                String passphrase = scanner.nextLine();
                if (passphrase.equals("")) {
                    String guess = VigenereAnalysis.bestGuess(cipher, Analysis.ALPHABET);
                    System.out.println(guess);
                } else {
                    Vigenere vigenere = new Vigenere();
                    System.out.println(vigenere.decrypt(cipher, passphrase));
                }
                break;
            }
            default:
                System.out.println("command unrecognized");
                break;
        }
    }

    public static void keyedVigenere(Scanner scanner) {
        System.out.println("encrypt or decrypt");
        String line4 = scanner.nextLine();
        switch (line4) {
            case "encrypt": {
                System.out.println("enter plaintext");
                String plain = scanner.nextLine();
                System.out.println("enter passphrase");
                String passphrase = scanner.nextLine();
                System.out.println("enter key");
                String key = scanner.nextLine();
                KeyedVigenere kvig = new KeyedVigenere(key);
                System.out.println(kvig.encrypt(plain, passphrase));
                break;
            }
            case "decrypt": {
                System.out.println("enter ciphertext");
                String cipher = scanner.nextLine();
                System.out.println("enter passphrase");
                String passphrase = scanner.nextLine();
                System.out.println("enter key");
                String key = scanner.nextLine();
                KeyedVigenere kvig = new KeyedVigenere(key);
                System.out.println(kvig.decrypt(cipher, passphrase));
                break;
            }
            default:
                System.out.println("command unrecognized");
                break;
        }
    }
}
