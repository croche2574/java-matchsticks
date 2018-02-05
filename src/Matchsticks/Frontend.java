/*
* Class representing the interface
*/
package Matchsticks;

import java.util.Scanner;

public class Frontend {
    //Shows start menu, and returns the selection
    public String startMenu() {
        Scanner in = new Scanner(System.in);

        System.out.println("Matchsticks");
        System.out.println("-----------");
        System.out.println("Pick an option:");
        System.out.println("a). One Player against Dumb Computer");
        System.out.println("b). Two Players Vs. Mode");
        System.out.print(">");

        String choice = in.nextLine().toLowerCase();

        return choice;
    }
    //Shows the turn select menu
    public Boolean turnPrompt() {
        Scanner in = new Scanner(System.in);
        Boolean oneFirst = true;

        System.out.println("Pick an option:");
        System.out.println("a). Player One");
        System.out.println("b). Player Two/Computer");
        System.out.print(">");
        String choice = in.nextLine().toLowerCase();
        switch (choice) {
        case "a":
            oneFirst = true;

            System.out.println("Player One goes first.");
            break;
        case "b":
            oneFirst = false;
            System.out.println("Player One goes second.");
            break;
        default:
            System.out.print("Please try again");
            turnPrompt();
            break;
        }

        return oneFirst;
    }
    //Displays the current board-state
    public void displayBoardstate(GameBoard board) {
        int[] state = board.getBoardstate();

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
    //Displays the apropriate error message
    public static void handleError(String errorType) {
        switch (errorType) {
        case "overMaxMatches":
            System.out.println("Amount chosen is larger than number of matches");
            break;

        case "badRow":
            System.out.println("Please choose a row listed");
            break;

        default:
            break;
        }
    }
    //Displays the Play again menu
    public static void gameOver() {
        Scanner in = new Scanner(System.in);
        System.out.println("Play again? [Y/N]");
        System.out.print(">");
        String choice = in.nextLine();

        switch (choice) {
        case "y":
            System.out.println("Starting game...");
            MatchsticksGame.StartGame();
            break;
        case "n":
            System.out.println("Bye!");
            break;
        default:
            System.out.println("Please Enter Y or N");
            gameOver();

        }
        in.close();
    }
}