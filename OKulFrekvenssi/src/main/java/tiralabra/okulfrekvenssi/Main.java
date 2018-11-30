package tiralabra.okulfrekvenssi;

import tiralabra.okulfrekvenssi.Ciphers.*;
import tiralabra.okulfrekvenssi.Analyysi.CaesarAnalysis;
import tiralabra.okulfrekvenssi.Analyysi.Analysis;
import java.util.Scanner;
import tiralabra.okulfrekvenssi.Analyysi.VigenereAnalysis;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("enter command, q to quit");
            String line = scanner.nextLine();
            switch (line) {
                case "q":
                    exit = true;
                    break;
                //TODO
                case "help":
                    System.out.println("Currently supported ciphers:");
                    System.out.println("caesar, keyed caesar, vigenere, keyed vigenere");
//                    System.out.println("enter \"caesar\" to encrypt or decrypt");
                    break;
                case "caesar":
                    Caesar(scanner);
                    break;
                case "keyed caesar":
                    keyedCaesar(scanner);
                    break;
                case "vigenere":
                    vigenere(scanner);
                    break;
                case "keyed vigenere":
                    keyedVigenere(scanner);
                    break;

                default:
                    System.out.println("command \"" + line + "\" unrecognized");
                    break;
            }
        }
        scanner.close();
    }

    private static void Caesar(Scanner scanner) {
        System.out.println("encrypt or decrypt");
        String line2 = scanner.nextLine();
        switch (line2) {
            case "encrypt": {
                System.out.println("enter plaintext");
                String plain = scanner.nextLine();
                System.out.println("enter offset");
                int offset = Integer.parseInt(scanner.nextLine());
                Caesar caesar = new Caesar();
                System.out.println(caesar.encrypt(plain, offset));
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
                            .bestGuess(cipher, Analysis.ALPHABET);
                    System.out.println(caesar.decrypt(cipher, guess));
                    System.out.println("is this correct y/n?");
                    String yn = scanner.nextLine();
                    if (yn.toLowerCase().equals("y")) {
                        break;
                    } else {
                        System.out.println("Other possibilities:");
                        for (int i = 0; i < Analysis.ALPHABET.length; i++) {
                            System.out.println(caesar.decrypt(cipher, i));
                            System.out.println("----------------------------------------------------------");
                        }
                        break;
                    }
                }

                System.out.println(caesar.decrypt(cipher, offset));
                break;
            }
            default:
                System.out.println("command unrecognized");
                break;
        }
    }

    private static void keyedCaesar(Scanner scanner) {
        System.out.println("encrypt or decrypt");
        String lineKeyedC = scanner.nextLine();
        switch (lineKeyedC) {
            case "encrypt": {
                System.out.println("enter plaintext");
                String plain = scanner.nextLine();
                System.out.println("enter offset");
                int offset = Integer.parseInt(scanner.nextLine());
                System.out.println("enter key");
                String key = scanner.nextLine();
                KeyedCaesar kcaesar = new KeyedCaesar(key);
                System.out.println(kcaesar.encrypt(plain, offset));
                break;
            }
            case "decrypt": {
                System.out.println("enter ciphertext");
                String cipher = scanner.nextLine();
                System.out.println("enter offset");
                int offset = Integer.parseInt(scanner.nextLine());
                System.out.println("enter key");
                String key = scanner.nextLine();
                KeyedCaesar kcaesar = new KeyedCaesar(key);
                System.out.println(kcaesar.decrypt(cipher, offset));
                break;
            }
            default:
                System.out.println("command unrecognized");
                break;
        }
    }

    private static void vigenere(Scanner scanner) {
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

    private static void keyedVigenere(Scanner scanner) {
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
