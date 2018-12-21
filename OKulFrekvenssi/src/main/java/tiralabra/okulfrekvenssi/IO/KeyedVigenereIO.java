/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.okulfrekvenssi.IO;

import java.util.Scanner;
import tiralabra.okulfrekvenssi.Analyysi.Analysis;
import tiralabra.okulfrekvenssi.Analyysi.KVigenereManualAnalysis;
import tiralabra.okulfrekvenssi.util.Alphabet;
import tiralabra.okulfrekvenssi.util.OmaTuple;
import tiralabra.okulfrekvenssi.Ciphers.KeyedVigenere;

/**
 *
 * @author Oskari
 */
public class KeyedVigenereIO {

    /**
     *
     * @param scanner käytetty Scanner
     */
    public static void keyedVigenere(Scanner scanner) {
        System.out.println("encrypt/decrypt/analysis");
        String lineKeyedV = scanner.nextLine();
        switch (lineKeyedV) {
            case "encrypt": {
                try {
                    System.out.println("enter plaintext");
                    String plain = scanner.nextLine();
                    System.out.println("enter password");

                    String password = scanner.nextLine();
                    System.out.println("enter key");
                    String key = scanner.nextLine();
                    KeyedVigenere kvig = new KeyedVigenere(key, Alphabet.ENGLISH);
                    System.out.println(kvig.encrypt(plain, password));

                    break;
                } catch (Exception e) {
                    System.out.println("Malformed command");
                    System.out.println(e.toString());
                }
            }
            case "decrypt": {
                try {
                    System.out.println("enter ciphertext");
                    String cipher = scanner.nextLine();
                    System.out.println("enter password");
                    String password = scanner.nextLine();
                    System.out.println("enter key");
                    String key = scanner.nextLine();
                    KeyedVigenere kvig = new KeyedVigenere(key, Alphabet.ENGLISH);

                    System.out.println(kvig.decrypt(cipher, password));

                    break;
                } catch (Exception e) {
                    System.out.println("Malformed command");
                    System.out.println(e.toString());
                }
            }
            case "analysis": {
                kVigenereAnalysis(scanner);
                break;
            }
            default:
                System.out.println("command unrecognized");
                break;
        }
    }

    /**
     *
     * @param scanner käytetty Scanner
     */
    public static void kVigenereAnalysis(Scanner scanner) {
        try {
            System.out.println("enter ciphertext");
            String cipher = scanner.nextLine();

//            cipher = cipher.toLowerCase();

            System.out.println("enter password length");
            int cosets = Integer.parseInt(scanner.nextLine());
            boolean exit = false;
            KVigenereManualAnalysis manualAnalysis = new KVigenereManualAnalysis(Alphabet.ENGLISH, cosets);
            KVigenereManualAnalysis[] saved = new KVigenereManualAnalysis[256];
            for (int i = 0; i < 256; i++) {
                saved[i] = new KVigenereManualAnalysis(Alphabet.ENGLISH, cosets);
            }
            int currentCoset = 0;

            while (!exit) {
                try {
                    System.out.println("enter command (map a b i, try a b, shift x, "
                            + "fill mapping, exit)");
                    String command = scanner.nextLine();
                    if (command.equals("exit")) {
                        exit = true;
                    } else if (command.startsWith("set coset")) {
                        currentCoset = Integer.parseInt(command.substring(10));
                        printAnalysis(manualAnalysis, cipher, currentCoset, cosets);
                    } else if (command.startsWith("map")) {
                        if (command.length() < 9) {
                            System.out.println("command \"" + command + "\" too short");
                        }

                        char a = command.toCharArray()[4];
                        char b = command.toCharArray()[6];
                        int i = Integer.parseInt(command.substring(8));
                        manualAnalysis.map(a, b, i);
                        printAnalysis(manualAnalysis, cipher, currentCoset, cosets);
                    } else if (command.startsWith("key")) {
                        if (command.length() < 5) {
                            System.out.println("key command missing parameter");
                        } else {
                            String key = command.substring(4);
                            manualAnalysis.setKey(key, currentCoset);
                            
                            printAnalysis(manualAnalysis, cipher, currentCoset, cosets);
                        }
                    } else if (command.equals("fill mapping")) {
                        manualAnalysis.fillMappings(currentCoset);
                        printAnalysis(manualAnalysis, cipher, currentCoset, cosets);

                    } else if (command.startsWith("shift")) {
                        try {
                            int shift = Integer.parseInt(command.substring(6));
                            manualAnalysis.setShift(shift, currentCoset);
                            printAnalysis(manualAnalysis, cipher, currentCoset, cosets);
                        } catch (NumberFormatException e) {
                            System.out.println("shift must be an integer");
                        }
                    } else if (command.startsWith("save")) {
                        if (command.length() < 6) {
                            System.out.println("save command missing parameter");
                        } else {
                            try {
                                int index = Integer.parseInt(command.substring(5));
                                saved[index] = manualAnalysis.copy();
                                System.out.println("saved to slot " + index);
                            } catch (NumberFormatException e) {
                                System.out.println("malformed command");
                            }

                        }
                    } else if (command.startsWith("load")) {
                        if (command.length() < 6) {
                            System.out.println("load command missing parameter");
                        } else {
                            try {
                                int index = Integer.parseInt(command.substring(5));
                                manualAnalysis = saved[index].copy();
                                System.out.println("loaded from slot " + index);
                                printAnalysis(manualAnalysis, cipher, currentCoset,
                                        cosets);
                            } catch (NumberFormatException e) {
                                System.out.println("malformed command");
                            }
                        }
                    } else if (command.equals("reset")) {
                        manualAnalysis = new KVigenereManualAnalysis(Alphabet.ENGLISH,
                                cosets);
                        for (int i = 0; i < 256; i++) {
                            saved[i] = new KVigenereManualAnalysis(Alphabet.ENGLISH,
                                    cosets);
                        }
                        System.out.println("Mapping reset");
                    } else if (command.equals("print")) {
                        printAnalysis(manualAnalysis, cipher, currentCoset,
                                cosets);
                    } else {
                        System.out.println("command \"" + command + "\" unrecognized");
                    }
                } catch (Exception e) {
                    System.out.println("Malformed command");
                    System.out.println(e.toString());
                }
            }
        } catch (Exception e) {
            System.out.println("malformed command");
        }

    }

    /**
     * Printtaa yhden sivuluokan kuvaukset ja frekvenssit sekä englannin
     * frekvenssit
     *
     * @param k1 käytetty analyysi
     * @param cipher salattu teksti
     * @param currentCoset sivuluokka
     * @param cosets sivuluokkien määrä (salasanan pituus)
     */
    public static void printAnalysis(KVigenereManualAnalysis k1, String cipher,
            int currentCoset, int cosets) {
        System.out.println("mapping");
        System.out.println(k1.getKeyedAbc(currentCoset));
        for (char c : k1.getKeyedAbc(currentCoset)) {
            System.out.print("|");
        }
        System.out.println("");
        char[] k1Abc = k1.getAbc();
        for (char c : k1Abc) {
            System.out.print("v");
        }
        System.out.println("");
        char[] mappedAbc = k1.getMappedAbc(currentCoset);
        for (int i = 0; i < mappedAbc.length; i++) {
            if (mappedAbc[i] != '\u0000') {
                System.out.print(mappedAbc[i]);
            } else {
                System.out.print('?');
            }
        }
        System.out.println();

        System.out.println(k1.translate(cipher));

        printFreq(cipher, k1Abc, currentCoset, cosets);

    }

    /**
     * Printtaa annetun sivuluokan ja englannin frekvenssit
     *
     * @param cipher salattu teksti
     * @param abc käytetty aakkosto
     * @param currentCoset sivuluokka
     * @param cosets sivuluokkien määrä
     */
    public static void printFreq(String cipher, char[] abc, int currentCoset,
            int cosets) {
        char[] cipherArray = cipher.toCharArray();
        char[] coset = (cipherArray.length % cosets == 0)
                ? new char[cipherArray.length / cosets]
                : new char[cipherArray.length / cosets + 1];
        for (int i = 0; i < cipherArray.length; i++) {
            if (i % cosets == currentCoset) {
                coset[i / cosets] = cipherArray[i];
            }
        }
        String cosetString = (new String(coset)).toLowerCase();
        double[] normFreq = Analysis.normalizedFrequencies(cosetString, abc);
        System.out.println(
                "Normalized frequencies (character, frequency in coset,"
                + " frequency in English): ");
        for (int i = 0; i < abc.length; i++) {
            if (i % 5 == 0) {
                System.out.println("");
            }
            System.out.print(abc[i] + ": "
                    + ((double) Math.round(normFreq[i] * 1000)) / 1000 + ", "
                    + ((double) Math.round(
                            Analysis.ENGLISH_NORMALIZED_FREQUENCY[i] * 1000))
                    / 1000);
            System.out.print("; ");
        }
        System.out.println("");

        OmaTuple[] engOrder = new OmaTuple[abc.length];
        OmaTuple[] cipherOrder = new OmaTuple[abc.length];

        for (int i = 0; i < abc.length; i++) {
            engOrder[i] = new OmaTuple(Analysis.ENGLISH_NORMALIZED_FREQUENCY[i],
                    Alphabet.ENGLISH[i]);
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
                    + ((double) Math.round(cipherOrder[i].getValue() * 1000))
                    / 1000 + ", "
                    + engOrder[i].getMerkki() + ": "
                    + ((double) Math.round(engOrder[i].getValue() * 1000))
                    / 1000);
            System.out.print("; ");
        }
        System.out.println("");
    }

}
