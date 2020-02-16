package Main;

import java.util.List;

class Calculator {
    Double calculate(List<String> polishNotationEquation) {
        for (int i = 0; i < polishNotationEquation.size(); i++) {

            if (ReversePolishNotation.mathOperation.containsKey(polishNotationEquation.get(i))) {
                switch (polishNotationEquation.get(i)) {
                    case "+":
                        polishNotationEquation.set(i - 2, String.valueOf(Double.parseDouble(polishNotationEquation.get(i - 2)) + Double.parseDouble(polishNotationEquation.get(i - 1))));
                        removeElementFromList(polishNotationEquation, i);
                        i -= 2;
                        break;
                    case "-":
                        polishNotationEquation.set(i - 2, String.valueOf(Double.parseDouble(polishNotationEquation.get(i - 2)) - Double.parseDouble(polishNotationEquation.get(i - 1))));
                        removeElementFromList(polishNotationEquation, i);
                        i -= 2;
                        break;
                    case "*":
                        polishNotationEquation.set(i - 2, String.valueOf(Double.parseDouble(polishNotationEquation.get(i - 2)) * Double.parseDouble(polishNotationEquation.get(i - 1))));
                        removeElementFromList(polishNotationEquation, i);
                        i -= 2;
                        break;
                    case "/":
                        polishNotationEquation.set(i - 2, String.valueOf(Double.parseDouble(polishNotationEquation.get(i - 2)) / Double.parseDouble(polishNotationEquation.get(i - 1))));
                        removeElementFromList(polishNotationEquation, i);
                        i -= 2;
                        break;
                }
            }
        }

        return Double.parseDouble(polishNotationEquation.get(0));
    }

    private void removeElementFromList(List<String> list, int i) {
        list.remove(i);
        list.remove(i - 1);
    }
}
