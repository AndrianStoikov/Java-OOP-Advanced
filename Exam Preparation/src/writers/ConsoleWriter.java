package writers;

/**
 * Created by Andrian on 15.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class ConsoleWriter implements Writer {
    @Override
    public void printLn(Object object) {
        System.out.println(object.toString());
    }
}
