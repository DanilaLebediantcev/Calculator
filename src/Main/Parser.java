package Main;

import java.util.List;

public class Parser {
    private String buffValue = "";

    List<String> startEquation(List<String> list) {

    }


    boolean isDigit(String value) {
        if (!ReversePolishNotation.mathOperation.containsKey(value)) {
            buffValue += value;
            return true;
        } else {
            return false;
        }

    }
}
