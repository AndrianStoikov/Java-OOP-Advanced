package readers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Andrian on 15.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class ConsoleReader implements Reader{
    private BufferedReader Console;

    public ConsoleReader() {
        this.Console = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String readLine() throws IOException {
        return Console.readLine();
    }
}
