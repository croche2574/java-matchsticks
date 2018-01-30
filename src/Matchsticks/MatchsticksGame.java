package Matchsticks;
import java.util.Scanner;
import java.util.Random;

public class MatchsticksGame {
    public static void main(String[] args) {
        StartGame();
    }

    public static void StartGame () {
        Random generator = new Random();
        int numPlayers = 1;
        Boolean smartComputer = true;
        Frontend display = new Frontend();

        smartComputer = display.startMenu();
        aiGame(smartComputer);
    }

    public static void aiGame(Boolean smart) {
        Random generator = new Random();
        Scanner in = new Scanner(System.in);
        Boolean playerFirst;
        Boolean playerWon = true;
        Player playerOne = new Player();
        GameBoard board = new GameBoard();
        AI computer = new AI(smart);
        Frontend display = new Frontend();

        if (generator.nextInt(2) == 1) {
            System.out.println("Computer goes first.");
            playerFirst = false;
        } else {
            System.out.println("You go first.");
            playerFirst = true;
        }
       
        while (board.totalMatches() != 0) {
            display.displayBoardstate(board.getBoardstate());
            if (playerFirst) {
                board.removeMatches(playerOne.prompt(board.getBoardstate()));
                if (board.totalMatches() != 0) {
                    board.removeMatches(computer.takeTurn(board.getBoardstate(), board.totalMatches()));
                }
                else {
                    playerWon = false;
                }
            }
            else {
                board.removeMatches(computer.takeTurn(board.getBoardstate(), board.totalMatches()));
                if (board.totalMatches() != 0) {
                    board.removeMatches(playerOne.prompt(board.getBoardstate()));
                }
                else {
                    playerWon = true;
                }
            }
        }
        if (playerWon) {
            System.out.println("You won!");
        } else {
            System.out.println("You lost.");
        }

        gameOver();
    }

    public static void gameOver() {
        Scanner in = new Scanner(System.in);
        System.out.println("Play again? [Y/N]");
        String choice = in.nextLine();

        switch (choice) {
            case "y":
                System.out.println("Starting game...");
                StartGame();
                break;
            case "n":
                System.out.println("Bye!");
                break;
            default:
                System.out.println("Please Enter Y or N");
                gameOver();
                
        }
    }
}
