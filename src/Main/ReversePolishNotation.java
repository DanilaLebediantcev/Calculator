package Main;

import java.util.*;

public class ReversePolishNotation {

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
            if (isDigit(allSymbolsList.get(i))) {
                if (i == allSymbolsList.size() - 1) {
                    if (!buffValue.equals(""))
                        equation.add(buffValue);
                    for (int k = 0; k < stack.size(); k++) {
                        equation.add(stack.pop());
                        k--;
                    }
                }
            } else {
                if (stack.size() != 0 && mathOperation.get(allSymbolsList.get(i)) > mathOperation.get(stack.peek())) {
                    equation.add(buffValue);
                    buffValue = "";
                    stack.push(allSymbolsList.get(i));

                }else if(stack.size() != 0 && mathOperation.get(allSymbolsList.get(i)).equals(mathOperation.get(stack.peek()))){
                    equation.add(buffValue);
                    buffValue = "";
                    equation.add(stack.pop());
                    stack.push(allSymbolsList.get(i));
                }else {
                    equation.add(buffValue);
                    buffValue = "";
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

    boolean isDigit(String value) {
        if (!mathOperation.containsKey(value)) {
            buffValue += value;
            return true;
        } else {
            return false;
        }
    }

}
