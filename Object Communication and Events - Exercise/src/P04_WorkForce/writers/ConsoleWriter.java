package P04_WorkForce.writers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Andrian on 13.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class ConsoleWriter implements Writer {
    public ConsoleWriter() {

    }

    @Override
    public void printLn(String message) {
        System.out.println(message);
    }
}
