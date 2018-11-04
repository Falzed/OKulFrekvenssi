package tiralabra.okulfrekvenssi;

public class Main {

    public static void main(String[] args) {

        Vigenere vig = new Vigenere();
        char[][] kt = vig.getKeytable();
        System.out.println(vig.encrypt("Thisisatestmessagetobreak", "abc"));
//        for (char[] rivi : kt) {
//            String a = new String(rivi);
//            System.out.println(a);            
//        }
    }
}
