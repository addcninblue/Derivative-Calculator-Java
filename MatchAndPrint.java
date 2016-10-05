import java.util.regex.*;
public class MatchAndPrint {

    /**
     * gets the string and prints the derivative of all polynomials of the form __x^__
     * @param userInput
     */
    public static void Polynomials(String userInput){
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
            boolean outputSign = (polynomialsMatcher.group(1).equals("+") == power >= 0); 

            double outputCoefficient = Math.abs(coefficient * power);
            double outputPower = power - 1;

            if(first && !outputSign) {
                System.out.print(" -");
            } else if(!outputSign){ // if negative
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

    /**
    * gets the string and prints the derivative of all polynomials of the form __e^__x
    */
    public static void E(String userInput){
        Pattern E = Pattern.compile("(?:([+-])([\\d\\.]*)e(?:\\^([-]?[\\d\\.]*))?x?)");
        Matcher EMatcher = E.matcher(userInput);

        while(EMatcher.find()){ // for all matches, return output

            // Sets coefficient to user input if exists (2nd capturing group).
            // Otherwise, set to 1
            double coefficient = 1; // default
            if(EMatcher.group(2) != null && EMatcher.group(2).length() > 0)
                coefficient = Double.parseDouble(EMatcher.group(2));

            // Sets power to user input if exists (3rd capturing group).
            // Otherwise, set to 1
            double power = 1; //if power is nonexistant then it's 1 
            if(EMatcher.group(3) != null)
                power = Double.parseDouble(EMatcher.group(3));

            // for result: true if positive, false if negative (takes into account sign of power)
            boolean outputSign = (EMatcher.group(1).equals("+") && power >= 0); 

            double outputCoefficient = coefficient * power;
            double outputPower = power;

            // if(!outputSign){ // if negative
            //     System.out.print("- ");
            // } else if(!first && outputSign){ // if not first and positive
            //     System.out.print("+ ");
            // }

            System.out.print(outputCoefficient + "e^" + outputPower + "x");

            // if (outputPower == 1){
            //     System.out.print(outputCoefficient + "x ");
            // } else if (outputPower == 0){
            //     System.out.print(outputCoefficient + " ");
            // } else {
            //     System.out.print(outputCoefficient + "x^" + outputPower + " ");
            // }
        }
    }
}
