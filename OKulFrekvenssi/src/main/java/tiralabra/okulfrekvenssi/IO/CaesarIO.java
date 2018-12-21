/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.okulfrekvenssi.IO;

import java.util.Scanner;
import tiralabra.okulfrekvenssi.Analyysi.CaesarAnalysis;
import tiralabra.okulfrekvenssi.Ciphers.Caesar;
import tiralabra.okulfrekvenssi.util.Alphabet;

/**
 *
 * @author Oskari
 */
public class CaesarIO {

    /**
     *
     * @param scanner käytetty skanneri
     */
    public static void Caesar(Scanner scanner) {
        System.out.println("encrypt or decrypt");
        String line2 = scanner.nextLine();
        switch (line2) {
            case "encrypt": {
                System.out.println("enter plaintext");
                String plain = scanner.nextLine();
                System.out.println("enter offset");
                int offset = Integer.parseInt(scanner.nextLine());
                Caesar caesar = new Caesar();
                System.out.println(caesar.encrypt(plain, offset, Alphabet.ENGLISH));
                break;
            }
            case "decrypt": {
                System.out.println("enter ciphertext");
                String cipher = scanner.nextLine();
                System.out.println("enter offset (-1 for unknown)");
                int offset = Integer.parseInt(scanner.nextLine());
                Caesar caesar = new Caesar();
                if (offset == -1) {
                    int guess = CaesarAnalysis
                            .bestGuess(cipher, Alphabet.ENGLISH);
                    System.out.println(caesar.decrypt(cipher, guess, Alphabet.ENGLISH));
                    System.out.println("is this correct y/n?");
                    String yn = scanner.nextLine();
                    if (yn.toLowerCase().equals("y")) {
                        break;
                    } else {
                        System.out.println("Other possibilities:");
                        for (int i = 0; i < Alphabet.ENGLISH.length; i++) {
                            System.out.println(caesar.decrypt(cipher, i, Alphabet.ENGLISH));
                            System.out.println("----------------------------------------------------------");
                        }
                        break;
                    }
                }

                System.out.println(caesar.decrypt(cipher, offset, Alphabet.ENGLISH));
                break;
            }
            default:
                System.out.println("command unrecognized");
                break;
        }
    }

}
