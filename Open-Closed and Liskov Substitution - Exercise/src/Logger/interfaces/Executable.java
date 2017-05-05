package Logger.interfaces;

import java.lang.reflect.InvocationTargetException;

public interface Executable {

    void execute(String[] data) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;
}
