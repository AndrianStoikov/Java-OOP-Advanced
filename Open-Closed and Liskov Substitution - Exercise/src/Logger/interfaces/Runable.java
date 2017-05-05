package Logger.interfaces;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public interface Runable {
    void run() throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException;
}
