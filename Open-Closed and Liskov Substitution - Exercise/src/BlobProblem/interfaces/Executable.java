package BlobProblem.interfaces;

import java.lang.reflect.InvocationTargetException;

public interface Executable {
    void execute(String[] data) throws ClassNotFoundException, NoSuchMethodException, InstantiationException,
            IllegalAccessException, InvocationTargetException;
}
