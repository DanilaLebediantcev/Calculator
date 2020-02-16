package Main;

import java.io.IOException;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {


        Validations validations = new Validations();
        List<String> allSymbolsList = new Parser().startEquation();
        while (!validations.firstAndLastSymbolNotOperation(allSymbolsList) || !validations.checkRightSymbols(allSymbolsList) || !validations.divisionByZero(allSymbolsList) || !validations.severalOperation(allSymbolsList)) {
            allSymbolsList = new Parser().startEquation();
        }
        System.out.println(new Calculator().calculate(new ReversePolishNotation().equationForComputer(allSymbolsList)));
    }
}
