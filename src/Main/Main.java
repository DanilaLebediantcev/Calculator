package Main;


import java.io.IOException;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {

        Validations validations = new Validations();
        List<String> allSymbolsList = validations.allValidations();
        ReversePolishNotation s = new ReversePolishNotation();
        Calculator calculator = new Calculator();
        System.out.println(calculator.calculate(s.equationForComputer(allSymbolsList)));
    }
}
