package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Console {
     String enterExample() throws IOException {
        return new BufferedReader(new InputStreamReader(System.in)).readLine();
    }
}
