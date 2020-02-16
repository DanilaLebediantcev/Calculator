package Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class Parser {
    private String buffValue = "";
    private List<String> list = new Console().enterExample().chars().mapToObj(x -> (char) x).map(Objects::toString).collect(Collectors.toList());

    Parser() throws IOException {
    }

    List<String> startEquation() {
        List<String> startEquation = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            isDigit(list.get(i));
            if(ReversePolishNotation.mathOperation.containsKey(list.get(i))){
                if(!buffValue.isEmpty()) {
                    startEquation.add(buffValue);
                    buffValue = "";
                }
                startEquation.add(list.get(i));
            }
            if(i==list.size()-1){
                startEquation.add(buffValue);
                buffValue="";
            }
        }
        return startEquation;
    }


    private String isDigit(String value) {
        if (!ReversePolishNotation.mathOperation.containsKey(value)) {
            return buffValue+=value;
        } else {
            return value;
        }

    }
}
