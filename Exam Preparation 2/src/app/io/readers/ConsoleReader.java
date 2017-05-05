package app.io.readers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Andrian on 20.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class ConsoleReader implements Reader {
    private BufferedReader console;

    public ConsoleReader() {
        this.console = new BufferedReader(new InputStreamReader(System.in));
        ;
    }

    @Override
    public String readLine() throws IOException {
        return this.console.readLine();
    }
}
