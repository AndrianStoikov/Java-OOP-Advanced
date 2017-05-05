package writers;

/**
 * Created by Andrian on 12.4.2017 г..
 */
public class ConsoleWriter implements Writer {
    @Override
    public void println(String message) {
        System.out.println(message);
    }
}
