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
        String userInput = in.nextLine();
        // String[] expression = userInput.split("[-+]");
        
        // [coefficients]
        // [powers]
        // double[][] parsedExpression = new double[2][expression.length]; 

        if(userInput.charAt(0) != '-'){ // if initial is not a negative, it must be positive
            userInput = "+" + userInput;
        }

        Pattern pattern = Pattern.compile("(?:([+-])([\\d\\.]*)x(?:\\^([-]?[\\d\\.]+))?)"); // pattern and on
        Matcher patternMatcher = pattern.matcher(userInput);
        boolean first = true; // first in output
        while(patternMatcher.find()){
            double coefficient = Double.parseDouble(patternMatcher.group(2));
            double power = 0; //if power is nonexistant then it's 0 
            // String sign = patternMatcher.group(1);
            boolean sign = (patternMatcher.group(1).equals("+") && power > 0); // true if positive, false if negative

            if(patternMatcher.group(3) != null)
                power = Double.parseDouble(patternMatcher.group(3));

            double outputCoefficient = coefficient * power;
            double outputPower = power - 1;

            if(!sign){ // if negative
                System.out.print("- ");
            } else if(!first && sign){ // if not first and positive
                System.out.print("+ ");
            }
            if (power == 1){
                System.out.print(outputCoefficient + "x ");
            } else if (power == 0){
                System.out.print(outputCoefficient + " ");
            } else {
                System.out.print(outputCoefficient + "x^" + outputPower + " ");
            }

            if(first)
                first = !first; // not first anymore
        }

        // unneccessary because will be 0 anyways
        // 
        // Pattern third = Pattern.compile("(?:([+-])([\\d\\.]*))");
        // Matcher thirdMatcher = third.matcher(userInput);
        // while(thirdMatcher.find()){
        //     System.out.println(secondMatcher.group(1));
        // }

        // parse
        // for(int i = 0; i < expression.length; i++){
        //     if (expression[i].contains("x^")) { // for polynomials powers of two or greater

        //         // regex for format __x^__
        //         Pattern polynomials = Pattern.compile("([\\d\\.]*)x\\^([\\d\\.]+)");
        //         Matcher matcher = polynomials.matcher(expression[i]);
        //         matcher.find(); // finds match
        //         double coefficient = 1; 
        //         if(matcher.group(1).length() != 0)
        //             coefficient = Double.parseDouble(matcher.group(1)); // sets value to coefficient
        //         double power = Double.parseDouble(matcher.group(2)); // sets value to power
        //         parsedExpression[0][i] = coefficient * power;
        //         parsedExpression[1][i] = power - 1;

        //     } else if (expression[i].contains("x")) { //for polynomials power 1
                
        //         // regex for format __x^__
        //         Pattern polynomials = Pattern.compile("([\\d\\.]*)x");
        //         Matcher matcher = polynomials.matcher(expression[i]);
        //         matcher.find(); // finds match
        //         double coefficient = 1; 
        //         if(matcher.group(1).length() != 0)
        //             coefficient = Double.parseDouble(matcher.group(1)); // sets value to coefficient
        //         parsedExpression[0][i] = coefficient; // sets value to coefficient
        //         parsedExpression[1][i] = 0; // sets value to 0. (implied)
        //         if(matcher.group(1).length() == 0)
        //             parsedExpression[0][i] = 1; // sets coefficient to 1 in case group 1 is 0.

        //     } else { // for constants
        //         parsedExpression[0][i] = 0;
        //         parsedExpression[1][i] = 0;
        //         // parsedExpression[0][i] = Double.parseDouble(expression[i]);
        //     }
        // }

        // // print
        // for(int i = 0; i < parsedExpression[0].length; i++){
        //     if(parsedExpression[0][i] != 0)
        //     System.out.print(parsedExpression[0][i] + "x^" + parsedExpression[1][i]+ " + ");
        // }
    }
}
