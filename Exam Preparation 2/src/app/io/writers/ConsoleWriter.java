package app.io.writers;

/**
 * Created by Andrian on 20.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class ConsoleWriter implements Writer {
    @Override
    public void writeLn(String string) {
        System.out.println(string);
    }
}
