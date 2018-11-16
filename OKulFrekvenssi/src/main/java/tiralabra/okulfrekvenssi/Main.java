package tiralabra.okulfrekvenssi;

import tiralabra.okulfrekvenssi.Ciphers.Caesar;
import tiralabra.okulfrekvenssi.Analyysi.CaesarAnalysis;
import tiralabra.okulfrekvenssi.Analyysi.Analysis;
import java.util.Scanner;

public class Main {

    //käyttöliittymän alkua, vaatíi myöhemmin huomattavaa refaktorointia
    //syöttää atm tyhjän rivin caesar salauksen jälkeen, varmaan liittyy 
    //kokonaisluvun lukemiseen
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while(!exit) {
            System.out.println("enter command, q to quit");
            String line = scanner.nextLine();
            switch (line) {
                case "q":
                    exit = true;
                    break;
            //TODO
                case "help":
                    System.out.println("Currently only caesar cipher implemented");
                    System.out.println("enter \"caesar\" to encrypt or decrypt");
                    break;
                case "caesar":
                    System.out.println("encrypt or decrypt");
                    String line2 = scanner.nextLine();
                    switch (line2) {
                        case "encrypt":
                        {
                            System.out.println("enter plaintext");
                            String plain = scanner.nextLine();
                            System.out.println("enter offset");
                            int offset = Integer.parseInt(scanner.nextLine());
                            Caesar caesar = new Caesar();
                            System.out.println(caesar.encrypt(plain, offset));
                            break;
                        }
                        case "decrypt":
                        {
                            System.out.println("enter ciphertext");
                            String cipher = scanner.nextLine();
                            System.out.println("enter offset (-1 for unknown)");
                            int offset = Integer.parseInt(scanner.nextLine());
                            Caesar caesar = new Caesar();
                            if(offset==-1) {
                                int guess = CaesarAnalysis
                                        .bestGuess(cipher, Analysis.ALPHABET);
                                System.out.println(caesar.decrypt(cipher, guess));
                                System.out.println("is this correct y/n?");
                                String yn = scanner.nextLine();
                                if(yn.toLowerCase().equals("y")) {
                                    break;
                                } else {
                                    System.out.println("Other possibilities:");
                                    for(int i=0; i<Analysis.ALPHABET.length; i++) {
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
                    }   break;
                default:
                    System.out.println("command \""+ line +"\" unrecognized");
                    break;
            }
        }
        scanner.close();
    }
}
