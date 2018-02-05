/*
* Class representing the player.  Handles player input, and returns an array containing the row and the amount
* of matches removed.
*/

package Matchsticks;

import java.util.Scanner;

public class Player {
    public int[] response = new int[2];
    private GameBoard board;

    public Player(GameBoard game) {
        board = game;
    }

    public int[] prompt() {
        Scanner in = new Scanner(System.in);
        int selectedRow;
        int numMatches;

        System.out.println("Enter the number of the row then the number of matches (R M)");
        System.out.print(">");
        selectedRow = in.nextInt() - 1;
        numMatches = in.nextInt();

        response[0] = selectedRow;
        response[1] = numMatches;

        if (validateChoice()) {
            return response;
        } else {
            prompt();
        }
        return response;
    }

    public Boolean validateChoice() {
        Boolean validChoice = false;
        int selectedRow = response[0];
        int numMatches = response[1];
        int[] state = board.getBoardstate();

        //Checks if the row entered is a valid choice
        if (selectedRow >= 0 && selectedRow <= 2) {
            //Number of matches <= number in selected row
            if (numMatches <= state[selectedRow] && numMatches > 0) {
                System.out.println(numMatches + " matches removed from row " + (selectedRow + 1) + ".");
                validChoice = true;
            } else {
                Frontend.handleError("overMaxMatches");
            }
        } else {
            Frontend.handleError("badRow");
        }

        return validChoice;
    }
}