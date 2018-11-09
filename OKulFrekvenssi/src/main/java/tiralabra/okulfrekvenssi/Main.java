package tiralabra.okulfrekvenssi;

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
                            int offset = scanner.nextInt();
                            Caesar caesar = new Caesar();
                            System.out.println(caesar.encrypt(plain, offset));
                            break;
                        }
                        case "decrypt":
                        {
                            System.out.println("enter ciphertext");
                            String cipher = scanner.nextLine();
                            System.out.println("enter offset");
                            int offset = scanner.nextInt();
                            Caesar caesar = new Caesar();
                            System.out.println(caesar.encrypt(cipher, offset));
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
         
    }
}
