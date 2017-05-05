package interpreters;

import annotations.InjectArgs;
import annotations.InjectType;
import commands.Executable;
import core.ManagementSystem;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Andrian on 18.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class CommandInterpreter implements Interpreter{
    private static final String COMMANDS_PATH = "commands.";
    private static final String COMMAND = "Command";

    private ManagementSystem system;

    public CommandInterpreter(ManagementSystem system) {
        this.system = system;
    }

    @Override
    public String interperateCommand(String type, String[] data) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Executable> executableClass =
                (Class<Executable>) Class.forName(COMMANDS_PATH + type + COMMAND);

        Constructor<Executable> constructor = executableClass.getConstructor(ManagementSystem.class);
        Executable executable = constructor.newInstance(this.system);
        this.injectDependencies(executable, data);
        return executable.execute();
    }

    private void injectDependencies(Executable executable, String[] data) throws IllegalAccessException {
        Field[] fields = executable.getClass().getDeclaredFields();
        for (Field field : fields) {
            if(field.isAnnotationPresent(InjectArgs.class)) {
                field.setAccessible(true);
                field.set(executable, data);
            } else if(field.isAnnotationPresent(InjectType.class)) {
                field.setAccessible(true);
                field.set(executable, data[0]);
            }
        }
    }
}
