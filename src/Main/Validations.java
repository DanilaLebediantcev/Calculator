package Main;

import java.io.IOException;

import java.util.*;
import java.util.stream.Collectors;

public class Validations {
    private List<String> rightSybmols = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-", "*", "/");
    private List<String> allSymbolsList = new Console().enterExample().chars().mapToObj(x -> (char) x).map(Objects::toString).collect(Collectors.toList());
    private List<String> equation = new ArrayList<>();

    Validations() throws IOException {
    }

    List<String> allValidations() throws IOException {
        if (!firstAndLastSymbolNotOperation() || !checkRightSymbols()) {
            allSymbolsList = new Console().enterExample().chars().mapToObj(x -> (char) x).map(Objects::toString).collect(Collectors.toList());
            allValidations();
        }
        return allSymbolsList;
    }

    private boolean firstAndLastSymbolNotOperation() throws IOException {
        boolean number = true;
        if (ReversePolishNotation.mathOperation.containsKey(allSymbolsList.get(0)) || ReversePolishNotation.mathOperation.containsKey(allSymbolsList.get(allSymbolsList.size() - 1))) {
            System.out.println("Вы ввели некорректные данные, уравнение не может начаться или заканчиваться математической операцией");
            number = false;
        }
        return number;
    }

    private boolean checkRightSymbols() throws IOException {
        boolean number = true;
        for (String value : allSymbolsList) {
            if (!rightSybmols.contains(value)) {
                number = false;
            }
        }
        if (!number) {
            System.out.println("Вы ввели некоректные данные. Попробуйте снова:");
        }
        return number;
    }

    private boolean divisionByZero() throws IOException {
        List<String> startEquation = new ArrayList<>();
        for (int i = 0; i < allSymbolsList.size(); i++){
            if(ReversePolishNotation.i)
        }
    }

}
