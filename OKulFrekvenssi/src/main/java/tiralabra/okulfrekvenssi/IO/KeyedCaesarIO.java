/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.okulfrekvenssi.IO;

import java.util.Scanner;
import tiralabra.okulfrekvenssi.Analyysi.Analysis;
import tiralabra.okulfrekvenssi.Analyysi.KCaesarManualAnalysis;
import tiralabra.okulfrekvenssi.Analyysi.KeyedCaesarAnalysis;
import tiralabra.okulfrekvenssi.util.Alphabet;
import tiralabra.okulfrekvenssi.util.OmaTuple;

/**
 *
 * @author Oskari
 */
public class KeyedCaesarIO {

    public static void keyedCaesar(Scanner scanner) {
        System.out.println("encrypt/decrypt/analysis");
        String lineKeyedC = scanner.nextLine();
        switch (lineKeyedC) {
            case "encrypt": {
                System.out.println("enter plaintext");
                String plain = scanner.nextLine();
                System.out.println("enter offset");
                int offset = Integer.parseInt(scanner.nextLine());
                System.out.println("enter key");
                String key = scanner.nextLine();
                tiralabra.okulfrekvenssi.Ciphers.KeyedCaesar kcaesar = new tiralabra.okulfrekvenssi.Ciphers.KeyedCaesar(key);
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
                tiralabra.okulfrekvenssi.Ciphers.KeyedCaesar kcaesar = new tiralabra.okulfrekvenssi.Ciphers.KeyedCaesar(key);
                System.out.println(kcaesar.decrypt(cipher, offset));
                break;
            }
            case "analysis": {
                kCaesarAnalysis(scanner);
                break;
            }
            default:
                System.out.println("command unrecognized");
                break;
        }
    }

    public static void kCaesarAnalysis(Scanner scanner) {
        System.out.println("enter ciphertext");
        String cipher = scanner.nextLine();

        cipher = cipher.toLowerCase();

        boolean exit = false;
        KCaesarManualAnalysis manualAnalysis = new KCaesarManualAnalysis(Alphabet.SUOMI);
        KCaesarManualAnalysis[] saved = new KCaesarManualAnalysis[256];
        for (int i = 0; i < 256; i++) {
            saved[i] = new KCaesarManualAnalysis(Alphabet.SUOMI);
        }
        while (!exit) {
            System.out.println("enter command (map a b, try a b, shift x, "
                    + "fill mapping, exit)");
            String command = scanner.nextLine();
            if (command.equals("exit")) {
                exit = true;
            } else if (command.startsWith("map")) {
                if (command.length() < 7) {
                    System.out.println("command \"" + command + "\" too short");
                }

                char a = command.toCharArray()[4];
                char b = command.toCharArray()[6];
                manualAnalysis.map(a, b);
                printAnalysis(manualAnalysis, cipher);
            } else if (command.equals("fill mapping")) {
                manualAnalysis.fillMappings();
                printAnalysis(manualAnalysis, cipher);
            } else if (command.startsWith("key")) {
                if (command.length() < 5) {
                    System.out.println("key command missing parameter");
                } else {
                    String key = command.substring(4);
                    for (int i = 0; i < key.length(); i++) {
                        manualAnalysis.map(Alphabet.SUOMI[i], key.toCharArray()[i]);
                    }
                    manualAnalysis.fillMappings();
                    printAnalysis(manualAnalysis, cipher);
                }
            } else if (command.startsWith("save")) {
                if (command.length() < 6) {
                    System.out.println("save command missing parameter");
                } else {
                    int index = Integer.parseInt(command.substring(5));
                    saved[index] = manualAnalysis.copy();
                    System.out.println("saved to slot " + index);
                }
            } else if (command.startsWith("load")) {
                if (command.length() < 6) {
                    System.out.println("load command missing parameter");
                } else {
                    int index = Integer.parseInt(command.substring(5));
                    manualAnalysis = saved[index].copy();
                    System.out.println("loaded from slot " + index);
                    printAnalysis(manualAnalysis, cipher);
                }
            } else if (command.equals("reset")) {
                manualAnalysis = new KCaesarManualAnalysis(Alphabet.SUOMI);
                for (int i = 0; i < 256; i++) {
                    saved[i] = new KCaesarManualAnalysis(Alphabet.SUOMI);
                }
                System.out.println("Mapping reset");
            } else {
                System.out.println("command \"" + command + "\" unrecognized");
            }
        }
    }

    public static void printAnalysis(KCaesarManualAnalysis k1, String cipher) {
        System.out.println("mapping");
        System.out.println(k1.getAbc());
        for (char c : k1.getAbc()) {
            System.out.print("|");
        }
        System.out.println("");
        char[] k1Abc = k1.getAbc();
        for (char c : k1Abc) {
            System.out.print("v");
        }
        System.out.println("");
        char[] mappedAbc = k1.getMappedAbc();
        for (int i = 0; i < mappedAbc.length; i++) {
            if (mappedAbc[i] != '\u0000') {
                System.out.print(mappedAbc[i]);
            } else {
                System.out.print('?');
            }
        }
        System.out.println();

        System.out.println(k1.translate(cipher));

        printFreq(cipher, k1Abc);


    }

    public static void printFreq(String cipher, char[] abc) {
        double[] normFreq = Analysis.normalizedFrequencies(cipher, abc);
        System.out.println("Normalized frequencies (character, frequency in ciphertext, frequency in English): ");
        for (int i = 0; i < abc.length; i++) {
            if (i % 5 == 0) {
                System.out.println("");
            }
            System.out.print(abc[i] + ": "
                    + ((double) Math.round(normFreq[i] * 1000)) / 1000 + ", "
                    + ((double) Math.round(Analysis.ENGLISH_NORMALIZED_FREQUENCY[i] * 1000))
                    / 1000);
            System.out.print("; ");
        }
        System.out.println("");
        
        
        OmaTuple[] engOrder = new OmaTuple[abc.length];
        OmaTuple[] cipherOrder = new OmaTuple[abc.length];

        for (int i = 0; i < abc.length; i++) {
            engOrder[i] = new OmaTuple(Analysis.ENGLISH_NORMALIZED_FREQUENCY[i],
                    Analysis.ALPHABET[i]);
            cipherOrder[i] = new OmaTuple(normFreq[i], abc[i]);
        }
        engOrder = OmaTuple.omaMergeSort(engOrder);
        cipherOrder = OmaTuple.omaMergeSort(cipherOrder);
        
        System.out.println("Frequencies in order (frequency in ciphertext, "
                + "frequency in english)");
        for (int i = 0; i < abc.length; i++) {
            if (i % 4 == 0) {
                System.out.println("");
            }
            System.out.print(cipherOrder[i].getMerkki() + ": "
                    + ((double) Math.round(cipherOrder[i].getValue() * 1000)) / 1000 + ", "
                    + engOrder[i].getMerkki() + ": "
                    + ((double) Math.round(engOrder[i].getValue() * 1000))
                    / 1000);
            System.out.print("; ");
        }
        System.out.println("");
    }

}
