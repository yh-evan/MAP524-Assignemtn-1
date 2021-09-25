package yh.evanz.calculator_assignment1;

import java.util.List;

public class Calculation {

    int calc(List<String> inputs){
        int indexOfNum = 2;
        int indexOfOperator = 1;
        int result = Integer.parseInt(inputs.get(0));

        while (indexOfOperator < inputs.size()){
            switch (inputs.get(indexOfOperator)){
                case "+":
                    result += Integer.parseInt(inputs.get(indexOfNum));
                    break;
                case "-":
                    result -= Integer.parseInt(inputs.get(indexOfNum));
                    break;
                case "*":
                    result *= Integer.parseInt(inputs.get(indexOfNum));
                    break;
                case "/":
                    result /= Integer.parseInt(inputs.get(indexOfNum));
                    break;
            }
            indexOfNum+=2;
            indexOfOperator+=2;

        }

        return result;
    }

}
