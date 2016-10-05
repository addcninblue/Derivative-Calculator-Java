/**
 * This program will compute derivatives of linear functions.
 * @author Addison Chan
 * @version experimental
 */ 

import java.util.regex.*;
import java.util.Scanner;

public class main {
    public static void main (String [] args){

        Scanner in = new Scanner(System.in);
        String userInput = in.nextLine().replaceAll("\\s*","");

        if(userInput.charAt(0) != '-'){ // if initial is not a negative, it must be positive
            userInput = "+" + userInput;
        }

        // 1st capturing group [+-] matches signs
        // 2nd capturing group [\\d\\.]* matches coefficient
        // 3rd capturing group ?:\\^([-]?[\\d\\.]+) matches minus sign if present and power
        Pattern polynomials = Pattern.compile("(?:([+-])([\\d\\.]*)x(?:\\^([-]?[\\d\\.]+))?)"); // pattern and on
        Matcher polynomialsMatcher = polynomials.matcher(userInput);

        boolean first = true; // only for first in output, since it can't have + in front
        while(polynomialsMatcher.find()){ // for all matches, return output

            // Sets coefficient to user input if exists (2nd capturing group).
            // Otherwise, set to 1
            double coefficient = 1; // default
            if(polynomialsMatcher.group(2) != null && polynomialsMatcher.group(2).length() > 0)
                coefficient = Double.parseDouble(polynomialsMatcher.group(2));

            // Sets power to user input if exists (3rd capturing group).
            // Otherwise, set to 1
            double power = 1; //if power is nonexistant then it's 1 
            if(polynomialsMatcher.group(3) != null)
                power = Double.parseDouble(polynomialsMatcher.group(3));

            // for result: true if positive, false if negative (takes into account sign of power)
            boolean outputSign = (polynomialsMatcher.group(1).equals("+") && power >= 0); 

            double outputCoefficient = coefficient * power;
            double outputPower = power - 1;

            if(!outputSign){ // if negative
                System.out.print("- ");
            } else if(!first && outputSign){ // if not first and positive
                System.out.print("+ ");
            }
            if (outputPower == 1){
                System.out.print(outputCoefficient + "x ");
            } else if (outputPower == 0){
                System.out.print(outputCoefficient + " ");
            } else {
                System.out.print(outputCoefficient + "x^" + outputPower + " ");
            }

            if(first)
                first = !first; // not first anymore
        }
    }
}
