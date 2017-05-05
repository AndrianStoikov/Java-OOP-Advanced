package P03.core.factories;

import P03.contracts.CommandFactory;
import P03.contracts.Executable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CommandFactoryImpl implements CommandFactory{

    private static final String COMMANDS_PACKAGE_NAME =
            "P03.core.commands.";

    @Override
    public Executable createCommand(String command) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        command = Character.toUpperCase(command.charAt(0)) + command.substring(1);
        String commandName = COMMANDS_PACKAGE_NAME + command + "Command";
        Class<?> commandClass = Class.forName(commandName);
        Constructor<?> commandConstructor = commandClass.getDeclaredConstructor();
        return (Executable) commandConstructor.newInstance();
    }
}
