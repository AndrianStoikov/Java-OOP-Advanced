package app.interpreters;

import app.annotations.InjectData;
import app.commands.Executable;
import app.core.ProcessorSystem;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Andrian on 20.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class CommandInterpreter implements Interpreter {

    private static final String COMMAND_PATH = "app.commands.";
    private static final String COMMAND = "Command";

    private ProcessorSystem system;

    public CommandInterpreter(ProcessorSystem system) {
        this.system = system;
    }

    @Override
    public Executable interperateCommand(String type, String[] data) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Executable> executableClass =
                (Class<Executable>) Class.forName(COMMAND_PATH + type + COMMAND);
        Constructor<Executable> constructor = executableClass.getConstructor(ProcessorSystem.class);
        Executable executable = constructor.newInstance(this.system);
        this.injectDependecies(executable, data);
        return executable;
    }

    private void injectDependecies(Executable executable, String[] data) throws IllegalAccessException {
        Field[] fields = executable.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectData.class)) {
                field.setAccessible(true);
                field.set(executable, data);
            }
        }
    }
}
