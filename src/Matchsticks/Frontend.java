package Matchsticks;
import java.security.cert.TrustAnchor;
import java.util.Scanner;

public class Frontend {
    public String startMenu() {
        Scanner in = new Scanner(System.in);

        System.out.println("Matchsticks");
        System.out.println("-----------");
        System.out.println("Pick an option:");
        System.out.println("a). One Player against Smart Computer,");
        System.out.println("b). One Player against Dumb Computer");
        System.out.println("c). Two Players Vs. Mode");
        System.out.print(">");
        String choice = in.nextLine().toLowerCase();

        return choice;
    }
    public Boolean turnPrompt() {
        Scanner in = new Scanner(System.in);
        Boolean oneFirst = true;
        Boolean c = true;

        System.out.println("Pick an option:");
        System.out.println("a). Player One");
        System.out.println("b). Player Two/Computer");
        System.out.print(">");
        String choice = in.nextLine().toLowerCase();
        
        while (c) {
            switch (choice) {
                case "a":
                    oneFirst = true;
                    c = false;
                    System.out.println("Player One goes first.");
                    break;
                case "b":
                    oneFirst = false;
                    c = false;
                    System.out.println("Player One goes second.");
                    break;
                default:
                    System.out.print("Please try again");
                    break;
            }
        }
        return oneFirst;
    }
    public void displayBoardstate (int[] state) {
        System.out.println("Matchsticks");
        System.out.println("-----------");
        //m = matches per row in state[]
        for (int m : state) {
            for (int i = 1; i <= m; i++) {
                System.out.print("| ");
            }
            System.out.println("");
        }
    }
}
