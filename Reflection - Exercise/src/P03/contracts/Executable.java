package P03.contracts;

import java.lang.reflect.InvocationTargetException;

public interface Executable {

	String execute(String[] data) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;

}
