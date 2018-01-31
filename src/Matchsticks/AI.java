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
        int m = 0;
        Random generator = new Random();
        
        if (AIType) {
            System.out.println("Not Implemented Yet");
            MatchsticksGame.StartGame();
        }
        else {
            while (m == 0) {
                r = generator.nextInt(3);
                if (state[r] > 0) {
                    m = 1 + generator.nextInt(state[r]);
                }
            }
            
            if (m <= state[r]) {
                choice[0] = r;
                choice[1] = ((state[r] - m));
            }
        }
        System.out.println("The Computer removed " + m + " matches from row " + (r + 1) + ".");
        return choice;
    }
}
