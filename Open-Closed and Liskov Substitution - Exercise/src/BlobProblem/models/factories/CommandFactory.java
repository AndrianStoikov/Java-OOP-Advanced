package BlobProblem.models.factories;

import BlobProblem.interfaces.Executable;
import BlobProblem.models.commands.CreateCommand;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CommandFactory {
    private static final String COMMANDS_PATH = "BlobProblem.models.commands.";

    public static Executable createCommand(String[] cmdArgs) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String cmdName = cmdArgs[0];
        cmdName = Character.toUpperCase(cmdName.charAt(0)) + cmdName.substring(1);
        Class<?> behaviourClass = Class.forName(COMMANDS_PATH + cmdName + "Command");
        Constructor<?> behaviourConstructor = behaviourClass.getConstructor();
        return (Executable) behaviourConstructor.newInstance();
    }
}
