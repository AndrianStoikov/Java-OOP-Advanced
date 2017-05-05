package io.writers;

/**
 * Created by Andrian on 18.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class ConsoleWriter implements Writer {

    @Override
    public void write(Object object) {
        System.out.print(object.toString());
    }

    @Override
    public void write(String string) {
        System.out.print(string);
    }

    @Override
    public void writeln(Object object) {
        System.out.println(object.toString());
    }

    @Override
    public void writeln(String string) {
        System.out.println(string);
    }
}
