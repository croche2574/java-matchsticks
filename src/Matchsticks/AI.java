package Matchsticks;
import java.util.Random;

public class AI {
    private Boolean AIType;
    
    public AI(Boolean isSmart) {
        if (isSmart) {
            AIType = true;
        }
        else {
            AIType = false;
        }
    }

    public int[] takeTurn(int[] state, int total) {
        int[] choice = new int[2];
        int r = 0;
        int m = 1;
        Random generator = new Random();
        
        if (AIType) {
            System.out.println("Not Implemented Yet");
            MatchsticksGame.StartGame();
        }
        else {
            r = generator.nextInt(2);
            m = generator.nextInt(state[r]);

            if (m <= state[r]) {
                choice[0] = r;
                choice[1] = ((state[r] - m));
            }
        }
        System.out.println("The Computer removed " + m + " matches from row " + r + ".");
        return choice;
    }
}
