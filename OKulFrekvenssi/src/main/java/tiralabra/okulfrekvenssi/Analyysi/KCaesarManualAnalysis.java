/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.okulfrekvenssi.Analyysi;

import tiralabra.okulfrekvenssi.util.Alphabet;
import tiralabra.okulfrekvenssi.util.OmaHash;

/**
 *
 * @author Oskari
 */
public class KCaesarManualAnalysis {

    private OmaHash<Character, Character> mapping;
    private OmaHash<Character, Character> reverseMapping;

    private char[] abc;
    private String key;

    /**
     *
     * @param abc käytettävä aakkosto
     */
    public KCaesarManualAnalysis(char[] abc) {
        mapping = new OmaHash<>();
        reverseMapping = new OmaHash<>();
        this.abc = abc;
        this.key = "";
    }

    /**
     * Asettaa kuvauksen a-b (salaamaton-salattu)
     *
     * @param a salaamaton merkki
     * @param b salattu merkki
     */
    public void map(char a, char b) {
        this.mapping.put(a, b);
        this.reverseMapping.put(b, a);
    }

    public void setKey(String newKey) {
        for (int i = 0; i < newKey.length(); i++) {
            map(abc[i], newKey.toCharArray()[i]);
        }
        this.key = newKey;
    }

    public void setShift(int newShift) {
        OmaHash<Character, Character> newMapping = new OmaHash<>();
        OmaHash<Character, Character> newReverseMapping = new OmaHash<>();
        for (int i = 0; i < this.abc.length; i++) {
            //javan % voi palauttaa negatiivisen luvun joten vähän 
            //monimutkaisempi lasku
            char c = this.mapping.get(
                    abc[((i + newShift) % abc.length + abc.length)
                    % abc.length]);
            newMapping.put(abc[i], c);
            newReverseMapping.put(c, abc[i]);
        }
        this.mapping = newMapping;
        this.reverseMapping = newReverseMapping;
    }

    /**
     * Kopioi olion
     *
     * @return kopio
     */
    public KCaesarManualAnalysis copy() {
        KCaesarManualAnalysis newAnalysis = new KCaesarManualAnalysis(this.abc);
        newAnalysis.setMapping(mapping, reverseMapping);
        return newAnalysis;
    }

    /**
     * Asettaa annetut kuvaukset
     *
     * @param newMap salaamaton-salattu
     * @param newRev salattu-salaamaton
     */
    public void setMapping(OmaHash newMap, OmaHash newRev) {
        this.mapping = newMap.copy();
        this.reverseMapping = newRev.copy();
    }

    /**
     *
     * @return käytetty aakkosto
     */
    public char[] getAbc() {
        return abc;
    }

    /**
     *
     * @return salattu aakkosto
     */
    public char[] getMappedAbc() {
        char[] mapped = new char[abc.length];
        for (int i = 0; i < abc.length; i++) {
            if (mapping.get(abc[i]) != null) {
                mapped[i] = mapping.get(abc[i]);
            }
        }
        return mapped;
    }

    /**
     * Purkaa annetun merkkijonon salauksen
     *
     * @param cipher salattu teksti
     * @return salaamaton teksti
     */
    public String translate(String cipher) {
        char[] output = new char[cipher.length()];
        char input[] = cipher.toCharArray();
        for (int i = 0; i < cipher.length(); i++) {
//            if (mapping.get(input[i]) != null) {
//                output[i] = mapping.get(input[i]);
//            } else {
//                output[i] = '?';
//            }
            if (Alphabet.isLetter(input[i], this.abc)) {
                output[i] = (reverseMapping.get(input[i]) != null)
                        ? reverseMapping.get(input[i]) : '?';
//                System.out.println(input[i]);
            } else if (Alphabet.isLetter(input[i],
                    (new String(abc)).toUpperCase().toCharArray())) {
//                System.out.println(input[i]);
                output[i] = (reverseMapping.get(Character.toLowerCase(input[i]))
                        != null)
                                ? Character.toUpperCase(reverseMapping
                                        .get(Character.toLowerCase(input[i])))
                                : '?';
            } else {
                output[i] = input[i];
            }
        }
        return new String(output);
    }

    /**
     *
     */
    public void fillMappings() {
        OmaHash<Character, Character> mapped = new OmaHash<>();
        OmaHash<Character, Character> revMapped = new OmaHash<>();
        OmaHash<Character, Boolean> added = new OmaHash<>();

        for (char c : abc) {
            added.put(c, Boolean.FALSE);
        }

        for (int i = 0; i < abc.length; i++) {
            if (mapping.get(abc[i]) != null) {
                mapped.put(abc[i], mapping.get(abc[i]));
                revMapped.put(mapping.get(abc[i]), abc[i]);

                added.put(mapping.get(abc[i]), Boolean.TRUE);
            } else {
                char charToAdd = firstNotAdded(abc, added);
                added.put(charToAdd, Boolean.TRUE);
                mapped.put(abc[i], charToAdd);
                revMapped.put(charToAdd, abc[i]);

            }
        }
        setMapping(mapped, revMapped);
    }

    /**
     * Etsii annetuista merkeistä ensimmäisen, joka ei ole annetussa OmaHashissä
     * arvolla TRUE
     *
     * @param abc aakkosto
     * @param added mitkä merkit on lisätty jo (ja mitkä eivät ole)
     * @return ensimmäinen merkki jonka arvo on FALSE
     */
    public char firstNotAdded(char[] abc, OmaHash<Character, Boolean> added) {
        for (char c : abc) {
            if (!added.get(c)) {
                return c;
            }
        }
        return '\u0000';
    }

}
