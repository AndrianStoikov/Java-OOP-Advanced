package app.interpreters;

import app.commands.Executable;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Andrian on 20.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public interface Interpreter {
    Executable interperateCommand(String type, String[] data) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}
