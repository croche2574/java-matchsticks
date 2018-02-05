package Matchsticks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MiniMax {
    private int[] state;
    private int[] move = new int[2];
    private GameBoard board;

    public List<int[]> moves = new ArrayList<int[]>();
    public Boolean win;

    public MiniMax(GameBoard game) {
        board = game;
    }

    public Boolean win(String player) {
        if (board.totalMatches() == 1 && player == "human") {
            return true;
        }
        return false;
    }

    public void collectMoves() {

        state = board.getBoardstate();
        for (int r = 0; r < state.length; r++) {

            for (int m = 1; m <= state[r]; m++) {

                move[0] = r;
                move[1] = m;
                moves.add(move);
                System.out.println(Arrays.toString(move));
            }

        }
        for (int[] intArr : moves) {
            System.out.println(Arrays.toString(intArr));
        }
    }

    public void minMax() {

    }

}
