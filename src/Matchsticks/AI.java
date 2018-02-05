/*
* Class representing the Computer.  Handles computer's turn, and returns an array containing the row and the amount
* of matches removed.
*
*/
package Matchsticks;

import java.util.Random;

public class AI extends Player {
    private Boolean AIType;

    public AI(Boolean isSmart, GameBoard game) {
        super(game);
        AIType = isSmart;
    }

    public int[] compTurn(GameBoard board) {

        if (AIType) {
            smartChoice(board);
        } else {
            randChoice(board);
        }
        return response;
    }

    public void randChoice(GameBoard board) {
        int[] state = board.getBoardstate();
        int r = 0;
        int m = 0;
        Random generator = new Random();

        while (m == 0) {
            r = generator.nextInt(3);
            if (state[r] > 0) {
                m = 1 + generator.nextInt(state[r]);
            }
        }

        if (m <= state[r]) {
            response[0] = r;
            response[1] = m;
        }
        System.out.println("The Computer removed " + response[1] + " matches from row " + (response[0] + 1) + ".");
    }

    public void smartChoice(GameBoard board) {
        MiniMax minmax = new MiniMax(board);
        minmax.collectMoves();
        //System.out.println("The Computer removed " + response[1] + " matches from row " + (response[0] + 1) + ".");
    }
}