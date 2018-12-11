/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.okulfrekvenssi.Analyysi;

import tiralabra.okulfrekvenssi.util.Alphabet;
import tiralabra.okulfrekvenssi.util.OmaHash;
import tiralabra.okulfrekvenssi.util.OmaJono;

/**
 *
 * @author Oskari
 */
public class KCaesarManualAnalysis {
//    private OmaHash<Character, Integer> charInt;
//    private OmaHash<Integer, Character> intChar;
//    private OmaHash<Character, Integer> charIntRev;
//    private OmaHash<Integer, Character> IntCharRev;

    private OmaHash<Character, Character> mapping;
    private OmaHash<Character, Character> reverseMapping;
    private char[] abc;

    public KCaesarManualAnalysis(char[] abc) {
        mapping = new OmaHash<>();
        reverseMapping = new OmaHash<>();
        this.abc = abc;
    }

    public KCaesarManualAnalysis testMapping(char a, char b) {
        KCaesarManualAnalysis newAnalysis = this.copy();
        newAnalysis.map(a, b);
        return newAnalysis;
    }

    public void map(char a, char b) {
        this.mapping.put(a, b);
        this.reverseMapping.put(b, a);
    }

    public KCaesarManualAnalysis copy() {
        KCaesarManualAnalysis newAnalysis = new KCaesarManualAnalysis(this.abc);
        newAnalysis.setMapping(mapping, reverseMapping);
        return newAnalysis;
    }

    public void setMapping(OmaHash newMap, OmaHash newRev) {
        this.mapping = newMap.copy();
        this.reverseMapping = newRev.copy();
    }

    public char[] getAbc() {
        return abc;
    }

    public char[] getMappedAbc() {
        char[] mapped = new char[abc.length];
        for (int i = 0; i < abc.length; i++) {
            if (mapping.get(abc[i]) != null) {
                mapped[i] = mapping.get(abc[i]);
            }
        }
        return mapped;
    }

    public String translate(String cipher) {
        char[] output = new char[cipher.length()];
        char input[] = cipher.toCharArray();
        for (int i = 0; i < cipher.length(); i++) {
//            if (mapping.get(input[i]) != null) {
//                output[i] = mapping.get(input[i]);
//            } else {
//                output[i] = '?';
//            }
            output[i] = (reverseMapping.get(input[i]) != null)
                    ? reverseMapping.get(input[i]) : '?';
        }
        return new String(output);
    }

    public void fillMappings() {
        System.out.println("fillMappings called");
        OmaHash<Character, Character> mapped = new OmaHash<>();
        OmaHash<Character, Character> revMapped = new OmaHash<>();
        OmaHash<Character, Boolean> added = new OmaHash<>();

        //ei kai tarvitsisi
        for (char c : abc) {
            added.put(c, Boolean.FALSE);
        }
        
        for (int i = 0; i < abc.length; i++) {
            if (mapping.get(abc[i]) != null) {
                System.out.println("found existing mapping: " + abc[i] + "->" + mapping.get(abc[i]));
                mapped.put(abc[i], mapping.get(abc[i]));
                revMapped.put(mapping.get(abc[i]), abc[i]);

                added.put(mapping.get(abc[i]), Boolean.TRUE);
            } else {
                char charToAdd = firstNotAdded(abc, added);
                added.put(charToAdd, Boolean.TRUE);
                mapped.put(abc[i], charToAdd);
                revMapped.put(charToAdd, abc[i]);

                System.out.println("new mapping: " + abc[i] + "->" + charToAdd);

            }
        }
        setMapping(mapped, revMapped);
    }

    public char firstNotAdded(char[] abc, OmaHash<Character, Boolean> added) {
        for (char c : abc) {
            System.out.println(c+": "+added.get(c));
            if (!added.get(c)) {
                return c;
            }
        }
        return '\u0000';
    }

}
