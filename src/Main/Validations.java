package Main;


import java.util.*;

class Validations {
    private List<String> rightSymbols = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-", "*", "/");
    private List<String> newList = new ArrayList<>();


    boolean firstAndLastSymbolNotOperation(List<String> list) {
        boolean number = true;
        if (ReversePolishNotation.mathOperation.containsKey(list.get(0)) || ReversePolishNotation.mathOperation.containsKey(list.get(list.size() - 1))) {
            System.out.println("Вы ввели некорректные данные, уравнение не может начаться или заканчиваться математической операцией");
            number = false;
        }
        return number;
    }

    boolean checkRightSymbols(List<String> list) {
        boolean number = true;
        for (String value : list) {
            for (char bufval : value.toCharArray()) {
                if (!rightSymbols.contains(String.valueOf(bufval))) {
                    number = false;
                    break;
                }
            }
        }
        if (!number) {
            System.out.println("Вы ввели некоректные данные. Попробуйте снова:");
        }
        return number;
    }

    boolean divisionByZero(List<String> list) {
        boolean trueFalse = true;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("/")) {
                if (Double.parseDouble(list.get(i + 1)) == 0.0) {
                    System.out.println("Делить на 0 нельзя! Введите уравнение заново:");
                    trueFalse = false;
                    break;
                }
            }
        }
        return trueFalse;
    }

    boolean severalOperation(List<String> list) {
        boolean trueFalse = true;
        for (int i = 0; i < list.size(); i++) {
            if (ReversePolishNotation.mathOperation.containsKey(list.get(i)) && ReversePolishNotation.mathOperation.containsKey(list.get(i + 1))) {
                System.out.println("Не может идти несколько математических операций подряд. Введите уравнение заново:");
                trueFalse = false;
                break;
            }
        }
        return trueFalse;
    }

}
