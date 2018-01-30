package Matchsticks;
import java.util.Scanner;

public class Frontend {
    public Boolean startMenu() {
        Scanner in = new Scanner(System.in);
        Boolean smartComputer = false;

        System.out.println("Matchsticks");
        System.out.println("-----------");
        System.out.println("Pick an option:");
        System.out.println("a). One Player against Smart Computer,");
        System.out.println("b). One Player against Dumb Computer");
        System.out.print(">");
        String choice = in.nextLine().toLowerCase();

        switch (choice) {
            case "a": 
                smartComputer = true;
                //System.out.println("Playing against Smart Computer");
                break;
            case "b": 
                smartComputer = false;
                System.out.println("Playing against Dumb Computer");
                break;
            default: 
                System.out.println("Please Try Again");
                MatchsticksGame.StartGame();
                break;
        }

        return smartComputer;
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
