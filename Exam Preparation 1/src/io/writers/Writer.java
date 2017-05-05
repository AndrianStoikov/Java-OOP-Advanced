package io.writers;

/**
 * Created by Andrian on 18.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public interface Writer {
    void write(Object object);

    void write(String string);

    void writeln(Object object);

    void writeln(String string);
}
