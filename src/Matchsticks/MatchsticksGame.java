/*
* Main game code.  Handles turn order, starts the game, and handles the game modes.
*/
package Matchsticks;

public class MatchsticksGame {
    //Class main, starts the game
    public static void main(String[] args) {
        StartGame();
    }

    //Starts the game and handles the main menu input
    public static void StartGame() {
        Boolean twoPlayer = false;
        Frontend display = new Frontend();
        String choice;

        choice = display.startMenu();

        switch (choice) {
        case "a":
            System.out.println("Playing against Dumb Computer");
            break;
        case "b":
            twoPlayer = true;
            System.out.println("Playing 2 player Vs. Mode");
            break;
        default:
            System.out.println("Please Try Again");
            MatchsticksGame.StartGame();
            break;
        }
        //Starts the chosen game mode
        if (twoPlayer) {
            vsGame();
        } else {
            aiGame();
        }
    }
    //Two player game mode
    public static void vsGame() {
        //Initialize board, players, and display
        Boolean playerOneFirst;
        Boolean playerOneWins = true;
        GameBoard board = new GameBoard();
        Player playerOne = new Player(board);
        Player playerTwo = new Player(board);
        Frontend display = new Frontend();

        playerOneFirst = display.turnPrompt();

        display.displayBoardstate(board);
        //Loops until all matches are removed
        while (board.totalMatches() != 0) {
            if (playerOneFirst) {
                board.removeMatches(playerOne.prompt());
                display.displayBoardstate(board);
                if (board.totalMatches() != 0) {
                    board.removeMatches(playerTwo.prompt());
                    display.displayBoardstate(board);
                } else {
                    playerOneWins = false;
                }
            } else {
                board.removeMatches(playerTwo.prompt());
                display.displayBoardstate(board);
                if (board.totalMatches() != 0) {
                    board.removeMatches(playerOne.prompt());
                    display.displayBoardstate(board);
                } else {
                    playerOneWins = true;
                }
            }
        }
        if (playerOneWins) {
            System.out.println("Player One Wins!");
        } else {
            System.out.println("Player Two Wins!");
        }
        Frontend.gameOver();
    }
    //Handles game against randomized computer
    public static void aiGame() {
        Boolean playerFirst = true;
        Boolean playerWon = true;
        GameBoard board = new GameBoard();
        Player playerOne = new Player(board);
        AI computer = new AI(board);
        Frontend display = new Frontend();

        playerFirst = display.turnPrompt();

        display.displayBoardstate(board);
        while (board.totalMatches() != 0) {
            if (playerFirst) {
                board.removeMatches(playerOne.prompt());
                display.displayBoardstate(board);
                if (board.totalMatches() != 0) {
                    board.removeMatches(computer.compTurn(board));
                    display.displayBoardstate(board);
                } else {
                    playerWon = false;
                }
            } else {
                board.removeMatches(computer.compTurn(board));
                display.displayBoardstate(board);
                if (board.totalMatches() != 0) {
                    board.removeMatches(playerOne.prompt());
                    display.displayBoardstate(board);
                } else {
                    playerWon = true;
                }
            }
        }
        if (playerWon) {
            System.out.println("You won!");
        } else {
            System.out.println("You lost.");
        }

        Frontend.gameOver();
    }
}