package P03.contracts;

import java.lang.reflect.InvocationTargetException;

public interface CommandFactory {

    Executable createCommand(String command) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}
