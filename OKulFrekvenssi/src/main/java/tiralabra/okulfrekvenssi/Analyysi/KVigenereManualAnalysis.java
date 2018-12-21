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
public class KVigenereManualAnalysis {

    private OmaHash<Character, Character>[] mappings;
    private OmaHash<Character, Character>[] reverseMappings;
    private char[] abc;
    private int cosets;

    /**
     *
     * @param abc käytetty aakkosto
     * @param cosets sivuluokkien määrä, eli salasanan pituus
     */
    public KVigenereManualAnalysis(char[] abc, int cosets) {
        mappings = new OmaHash[cosets];
        reverseMappings = new OmaHash[cosets];
        for(int i=0; i<cosets; i++) {
            mappings[i] = new OmaHash<>();
            reverseMappings[i] = new OmaHash<>();
        }
        this.abc = abc;
        this.cosets = cosets;
    }

    /**
     *
     * @return sivuluokkien määrä (salasanan pituus)
     */
    public int getCosets() {
        return cosets;
    }

    /**
     *
     * @param cosets sivuluokkien määrä (salasanan pituus)
     */
    public void setCosets(int cosets) {
        this.cosets = cosets;
        mappings = new OmaHash[cosets];
        reverseMappings = new OmaHash[cosets];
    }

    /**
     * Asettaa kuvauksen a-b (salaamaton-salattu) annetulle sivuluokalle
     * @param a salaamaton merkki
     * @param b salattu merkki
     * @param coset sivuluokka
     */
    public void map(char a, char b, int coset) {
        this.mappings[coset].put(a, b);
        this.reverseMappings[coset].put(b, a);
    }

    /**
     * Kopioi olion
     * @return kopio
     */
    public KVigenereManualAnalysis copy() {
        KVigenereManualAnalysis newAnalysis = new KVigenereManualAnalysis(this.abc, this.cosets);
        newAnalysis.setMappings(mappings, reverseMappings);
        return newAnalysis;
    }

    /**
     * Asettaa annetut kuvaukset (kaikille sivuluokille uudet)
     * @param newMaps salaamaton-salattu
     * @param newRevs salattu-salaamaton
     */
    public void setMappings(OmaHash[] newMaps, OmaHash[] newRevs) {
        for (int i = 0; i < mappings.length; i++) {
            this.mappings[i] = newMaps[i].copy();
            this.reverseMappings[i] = newRevs[i].copy();
        }
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
     * @param coset sivuluokka
     * @return käännetty aakkosto (sivuluokan kuvauksilla)
     */
    public char[] getMappedAbc(int coset) {
        char[] mapped = new char[abc.length];
        for (int i = 0; i < abc.length; i++) {
            if (mappings[coset].get(abc[i]) != null) {
                mapped[i] = mappings[coset].get(abc[i]);
            }
        }
        return mapped;
    }

    /**
     * Purkaa annetun tekstin salauksen
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
            output[i] = (reverseMappings[i%this.cosets].get(input[i]) != null)
                    ? reverseMappings[i%this.cosets].get(input[i]) : '?';
        }
        return new String(output);
    }
//
//    public void fillMappings() {
//        OmaHash<Character, Character> mapped = new OmaHash<>();
//        OmaHash<Character, Character> revMapped = new OmaHash<>();
//        OmaHash<Character, Boolean> added = new OmaHash<>();
//
//        //ei kai tarvitsisi
//        for (char c : abc) {
//            added.put(c, Boolean.FALSE);
//        }
//
//        for (int i = 0; i < abc.length; i++) {
//            if (mapping.get(abc[i]) != null) {
//                System.out.println("found existing mapping: " + abc[i] + "->" + mapping.get(abc[i]));
//                mapped.put(abc[i], mapping.get(abc[i]));
//                revMapped.put(mapping.get(abc[i]), abc[i]);
//
//                added.put(mapping.get(abc[i]), Boolean.TRUE);
//            } else {
//                char charToAdd = firstNotAdded(abc, added);
//                added.put(charToAdd, Boolean.TRUE);
//                mapped.put(abc[i], charToAdd);
//                revMapped.put(charToAdd, abc[i]);
//
//                System.out.println("new mapping: " + abc[i] + "->" + charToAdd);
//
//            }
//        }
//        setMapping(mapped, revMapped);
//    }

//    /**
//     *
//     * @param abc
//     * @param added
//     * @return
//     */
//    public char firstNotAdded(char[] abc, OmaHash<Character, Boolean> added) {
//        for (char c : abc) {
//            System.out.println(c + ": " + added.get(c));
//            if (!added.get(c)) {
//                return c;
//            }
//        }
//        return '\u0000';
//    }

}