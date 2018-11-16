package tiralabra.okulfrekvenssi;

//testausta/debugausta varten koodatessa

import tiralabra.okulfrekvenssi.Ciphers.Caesar;
import tiralabra.okulfrekvenssi.Ciphers.Vigenere;
import tiralabra.okulfrekvenssi.Analyysi.CaesarAnalysis;
import tiralabra.okulfrekvenssi.Analyysi.Analysis;
import java.util.Arrays;

public class manualTesting {

    public static void main(String[] args) {
        Vigenere vig = new Vigenere();
//        char[][] kt = vig.getKeytable();
//        System.out.println(vig.encrypt("Thisisatestmessagetobreak", "abc"));

        Caesar caesar = new Caesar();
//        System.out.println(caesar.encrypt("testmessage", 5));
//        for (char[] rivi : kt) {
//            String a = new String(rivi);
//            System.out.println(a);            
//        }
//        System.out.println(vig.encrypt("testmessage", "test"));
//        System.out.println(vig.encrypt("testboundary", "qwefgjnioxm"));
//        int[] freq = Analysis.calcFrequencies("aaaagwgiowego");
//        double[] freq = Analysis.normalizedFrequencies("aab");
//        for (int i = 0; i < freq.length; i++) {
//            System.out.print(freq[i]);
//            if (i != 28) {
//                System.out.print(", ");
//            }
//        }
//        System.out.println("");
//        int test = 5;
//        System.out.println(OmaHash.hash(test));
//        System.out.println(OmaHash.hash("test"));
//        System.out.println("test".hashCode());
//        System.out.println(3556498 ^ (3556498 >>> 16));
//        System.out.println(OmaHash.hash('a'));
//        int max = 97;
//        int min = 97;
//        char[] alphabet = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
//            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
//            'w', 'x', 'y', 'z', 'å', 'ä', 'ö'};
//        for (char c : alphabet) {
//            int n = OmaHash.hash(c);
//            if (n > max) {
//                max = n;
//            }
//            if (n < min) {
//                min = n;
//            }
//        }
//        System.out.println(max);
//        System.out.println(min);
//        System.out.println(OmaHash.hash(' '));
//        
//        OmaHash<Character, Integer> ohash = new OmaHash<>();
//        ohash.put('a', 5);
//        System.out.println(ohash.get('a'));

//        String testmessage = "Bring upon sixth all yielding waters firmament, own third days fill he deep lights called life unto meat every land were. Seas also rule.\n"
//                + "\n"
//                + "For won't day female fowl set his herb created spirit greater, his beast day land itself you're third evening created whose, dry firmament together multiply light gathering all replenish he creature.\n"
//                + "\n"
//                + "Fly herb let given sea she'd i gathering seed place meat seas after air, to. Made. It replenish. Unto. Fill together. Male void. Own a saying fill upon lesser appear very made is that. To let you. Whose lights image. Grass can't. Whose multiply after.";
        
        String testmessage="attackatdawnthisisatestmessage maybe this is longenough now";
        testmessage = testmessage.toLowerCase();
        testmessage = testmessage.replaceAll("[^a-z]", "");
        int k = CaesarAnalysis.bestGuess(testmessage, Analysis.ALPHABET);
        System.out.println(k);
        System.out.println(caesar.decrypt(testmessage, k));
        double sum = 0;
        
        double[] norm1 = Analysis.normalizedFrequencies(caesar.decrypt(testmessage, 0));
        double[] norm2 = Analysis.normalizedFrequencies(testmessage);
        System.out.println(Arrays.equals(norm1, norm2));
        System.out.println(testmessage.equals(caesar.decrypt(testmessage, 0)));
    }
}
