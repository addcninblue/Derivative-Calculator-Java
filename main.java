/**
 * This program will compute derivatives of linear functions.
 * @author Addison Chan
 * @version experimental
 */ 

public class main {
    public static void main (String [] args){
        // TODO: input
        // TODO: output
        
        // input.getString();
        String input = "4x^2+x+1";
        String[] expression = input.split("[-+]");
        String operators = new String;
        for(int i = 0; i < input.length; i++){
            if(input.charAt(i) == '+' || input.charAt(i) == '-') {
                operators += input.charAt(i);
            }
        }
        expression
        for(int i = 0; i < expression.length; i++){
            if (expression[i].contains('^') && expression[i].contains('x')){ // for polynomials powers of two or greater
                if(expression[i].charAt(0) == 'x'){
                    int constant = 1; //default is 1 because it's the implied coefficient
                } else {
                    int constant = 0; //default is 0 because makes easier for multiplication
                }
                int power = 0; // 0 == before x^; 1 == after x^
                int status = 0;
                for(int index = 0; index < expression[i].length(); index++){
                    if (expression[i].charAt(index) == 'x'){
                        status = 1; //means passed ^
                        index++; //advance past ^
                        continue;
                    }
                    if (status == 0) {
                        constant = constant * 10 + expression[i].charAt(index);
                    } else { //status == 1
                        power = power * 10 + expression[i].charAt(index);
                    }
                }
            } else if (expression[i].contains('x')) { //for polynomials power 1
                if (expression[i].charAt(0) == 'x'){
                    int constant = 0; // 0 == before x^; 1 == after x^
                } else {
                    int constant = 0; //default is 0 because makes easier for multiplication
                }
            } else { // for constants

            }
        }
        //TODO: return shit
    }
}
