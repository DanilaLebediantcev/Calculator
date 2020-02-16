package Main;

import java.util.*;

class ReversePolishNotation {

    private List<String> equation = new ArrayList<>();
    private Stack<String> stack = new Stack<>();
    private String buffValue = "";
    public final static Map<String, Integer> mathOperation = new HashMap<>();

    static {
        mathOperation.put("+", 0);
        mathOperation.put("-", 0);
        mathOperation.put("/", 1);
        mathOperation.put("*", 1);
    }

    List<String> equationForComputer(List<String> allSymbolsList) {
        for (int i = 0; i < allSymbolsList.size(); i++) {
            if (!mathOperation.containsKey(allSymbolsList.get(i))) {
                if (i == allSymbolsList.size() - 1) {
                    equation.add(allSymbolsList.get(i));
                    for (int k = 0; k < stack.size(); k++) {
                        equation.add(stack.pop());
                        k--;
                    }
                } else {
                    equation.add(allSymbolsList.get(i));
                }
            } else {
                if (stack.size() != 0 && mathOperation.get(allSymbolsList.get(i)) > mathOperation.get(stack.peek())) {
                    stack.push(allSymbolsList.get(i));

                } else if (stack.size() != 0 && mathOperation.get(allSymbolsList.get(i)).equals(mathOperation.get(stack.peek()))) {
                    equation.add(stack.pop());
                    stack.push(allSymbolsList.get(i));
                } else {
                    for (int k = 0; k < stack.size(); k++) {
                        equation.add(stack.pop());
                        k--;
                    }
                    stack.push(allSymbolsList.get(i));
                }
            }
        }
        return equation;
    }


}
