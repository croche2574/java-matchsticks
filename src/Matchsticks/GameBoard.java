package Matchsticks;

/**
 * @author croch
 *
 */
public class GameBoard {
    private int[] state = {7,5,3};

    public int[] getBoardstate() {
        return state;
    }

    public int totalMatches() {
        int total = 0;
        for (int num : state) {
            total += num;
        }        
        return total;
    }

    public void removeMatches(int[] amount) {
        state[amount[0]] = amount[1];        
    }
}
