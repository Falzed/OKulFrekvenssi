package tiralabra.okulfrekvenssi;

import tiralabra.okulfrekvenssi.Ciphers.*;
import tiralabra.okulfrekvenssi.Analyysi.CaesarAnalysis;
import tiralabra.okulfrekvenssi.Analyysi.Analysis;
import java.util.Scanner;
import tiralabra.okulfrekvenssi.Analyysi.*;
import tiralabra.okulfrekvenssi.util.Alphabet;
import tiralabra.okulfrekvenssi.IO.*;

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
                    CaesarIO.Caesar(scanner);
                    break;
                case "keyed caesar":
                    KeyedCaesarIO.keyedCaesar(scanner);
                    break;
                case "vigenere":
                    VigenereIO.vigenere(scanner);
                    break;
                case "keyed vigenere":
                    KeyedVigenereIO.keyedVigenere(scanner);
                    break;

                default:
                    System.out.println("command \"" + line + "\" unrecognized (main)");
                    break;
            }
        }
        scanner.close();
    }
}
