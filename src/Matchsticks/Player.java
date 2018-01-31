package Matchsticks;

import java.util.Scanner;

public class Player {
    
    public int[] prompt(int[] rows) {
        Scanner in = new Scanner(System.in);        
        int selectedRow;
        int numMatches;
        int[] response = new int[2];
        boolean validChoice = false;

        System.out.println("Enter the number of the row then the number of matches (R M)");

        while (!validChoice) {
            System.out.print(">");
            selectedRow = in.nextInt() - 1;
            numMatches = in.nextInt();

            if (selectedRow >= 0 && selectedRow <= 2) {
                //Number of matches <= number in selected row
                if (numMatches <= rows[selectedRow] && numMatches > 0) {
                    response[0] = selectedRow;
                    response[1] = (rows[selectedRow] - numMatches);
                    System.out.println(numMatches + " matches removed from row " + (selectedRow + 1) + ".");
                    validChoice = true;
                }
                else {
                    System.out.println(rows[selectedRow] + " is the max number of matches you can take. Try again");
                }
            }
            else {
                System.out.println("Please choose a row listed");
            }
        }

        return response;
    }

    
}
