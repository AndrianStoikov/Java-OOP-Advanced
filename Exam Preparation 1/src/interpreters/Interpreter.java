package interpreters;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Andrian on 18.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public interface Interpreter {

    String interperateCommand(String type, String[] data) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}
