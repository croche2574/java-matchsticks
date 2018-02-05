package Matchsticks;

/**
 * @author croch
 * Stores the gameboard state, and handles the update.
 */
public class GameBoard {
    private int[] state = { 7, 5, 3 };

    //Returns the board-state
    public int[] getBoardstate() {
        return state;
    }

    //Returns the total number of matches
    public int totalMatches() {
        int total = 0;
        for (int num : state) {
            total += num;
        }
        return total;
    }

    //Updates the board-state
    public void removeMatches(int[] amount) {
        int row = amount[0];
        int num = amount[1];
        state[row] -= num;
    }
}