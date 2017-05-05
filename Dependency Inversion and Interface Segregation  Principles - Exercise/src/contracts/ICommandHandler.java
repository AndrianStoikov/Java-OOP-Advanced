package contracts;

import exceptions.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface ICommandHandler {
    String ExecuteCommand(String name, List<String> parameters) throws Exception;
}
