package tiralabra.okulfrekvenssi;


//testausta/debugausta varten koodatessa
public class manualTesting {
    public static void main(String[] args) {
        Vigenere vig = new Vigenere();
        char[][] kt = vig.getKeytable();
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
        double[] freq = Analysis.normalizedFrequencies("aab");
        for (int i = 0; i < freq.length; i++) {
            System.out.print(freq[i]);
            if (i != 28) {
                System.out.print(", ");
            }
        }

    }
}
