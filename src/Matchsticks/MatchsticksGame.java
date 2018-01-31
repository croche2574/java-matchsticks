package Matchsticks;
import java.util.Scanner;
import java.util.Random;

public class MatchsticksGame {
    public static void main(String[] args) {
        StartGame();
    }

    public static void StartGame () {
        Random generator = new Random();
        Boolean smartComputer = false;
        Boolean twoPlayer = false;
        Frontend display = new Frontend();
        String choice;

        choice = display.startMenu();
        
        switch (choice) {
            case "a": 
                smartComputer = true;
                //System.out.println("Playing against Smart Computer");
                break;
            case "b": 
                smartComputer = false;
                System.out.println("Playing against Dumb Computer");
                
                break;
            case "c":
                twoPlayer = true;
                System.out.println("Playing 2 player Vs. Mode");
                
                break;
            default: 
                System.out.println("Please Try Again");
                MatchsticksGame.StartGame();
                break;
        }
        if (twoPlayer) {
            vsGame();
        }
        else {
            aiGame(smartComputer);
        }
    }

    public static void vsGame() {
        Random generator = new Random();
        Scanner in = new Scanner(System.in);
        Boolean playerOneFirst;
        Boolean playerOneWins = true;
        Player playerOne = new Player();
        Player playerTwo = new Player();
        GameBoard board = new GameBoard();
        Frontend display = new Frontend();

        playerOneFirst = display.turnPrompt();
        
        display.displayBoardstate(board.getBoardstate());
        while (board.totalMatches() != 0) {
            if (playerOneFirst) {
                board.removeMatches(playerOne.prompt(board.getBoardstate()));
                display.displayBoardstate(board.getBoardstate());
                if (board.totalMatches() != 0) {
                    board.removeMatches(playerTwo.prompt(board.getBoardstate()));
                    display.displayBoardstate(board.getBoardstate());
                }
                else {
                    playerOneWins = false;
                }
            }
            else {
                board.removeMatches(playerTwo.prompt(board.getBoardstate()));
                display.displayBoardstate(board.getBoardstate());
                if (board.totalMatches() != 0) {
                    board.removeMatches(playerOne.prompt(board.getBoardstate()));
                    display.displayBoardstate(board.getBoardstate());
                }
                else {
                    playerOneWins = true;
                }
            }
        }
        if (playerOneWins) {
            System.out.println("Player One Wins!");
        } else {
            System.out.println("Player Two Wins!");
        }
        gameOver();
    }

    public static void aiGame(Boolean smart) {
        Random generator = new Random();
        Scanner in = new Scanner(System.in);
        Boolean playerFirst = true;
        Boolean playerWon = true;
        Player playerOne = new Player();
        GameBoard board = new GameBoard();
        AI computer = new AI(smart);
        Frontend display = new Frontend();

        if (!smart) {
            playerFirst = display.turnPrompt();
        }
        else {
            System.out.println("Not Yet Implemented");
            StartGame();
        }
        display.displayBoardstate(board.getBoardstate());
        while (board.totalMatches() != 0) {
            if (playerFirst) {
                board.removeMatches(playerOne.prompt(board.getBoardstate()));
                display.displayBoardstate(board.getBoardstate());
                if (board.totalMatches() != 0) {
                    board.removeMatches(computer.takeTurn(board.getBoardstate(), board.totalMatches()));
                    display.displayBoardstate(board.getBoardstate());
                }
                else {
                    playerWon = false;
                }
            }
            else {
                board.removeMatches(computer.takeTurn(board.getBoardstate(), board.totalMatches()));
                display.displayBoardstate(board.getBoardstate());
                if (board.totalMatches() != 0) {
                    board.removeMatches(playerOne.prompt(board.getBoardstate()));
                    display.displayBoardstate(board.getBoardstate());
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
        System.out.print(">");
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
