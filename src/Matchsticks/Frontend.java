package Matchsticks;
import java.util.Scanner;

public class Frontend {
    public String startMenu() {
        Scanner in = new Scanner(System.in);

        System.out.println("Matchsticks");
        System.out.println("-----------");
        System.out.println("Pick an option:");
        System.out.println("a). One Player against Smart Computer,");
        System.out.println("b). One Player against Dumb Computer");
        System.out.println("c). Two Players Vs.");
        System.out.print(">");
        String choice = in.nextLine().toLowerCase();

        return choice;
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
