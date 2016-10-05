/**
 * This program will compute derivatives of linear functions.
 * @author Addison Chan
 * @version experimental
 */ 

import java.util.Scanner;

public class Main {
    public static void main (String [] args){
        Scanner in = new Scanner(System.in);
        String userInput = in.nextLine().replaceAll("\\s*","");

        if(userInput.charAt(0) != '-'){ // if initial is not a negative, it must be positive
            userInput = "+" + userInput;
        }

        MatchAndPrint.E(userInput);
        MatchAndPrint.Polynomials(userInput);
    }
}
