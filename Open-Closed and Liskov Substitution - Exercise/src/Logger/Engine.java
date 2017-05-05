package Logger;

import Logger.annotations.Inject;
import Logger.commands.ParseAppenderCommand;
import Logger.interfaces.Appender;
import Logger.interfaces.Executable;
import Logger.interfaces.Logger;
import Logger.interfaces.Runable;
import Logger.models.loggers.MessageLogger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Engine implements Runable {
    private static final String COMMAND_PATH = "Logger.commands.";

    private Logger logger;
    private List<Appender> appenders;

    public Engine(Logger logger) {
        this.logger = logger;
        this.appenders = new ArrayList<>();
    }

    @Override
    public void run() throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(Console.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = Console.readLine().split(" ");
            this.execAppenderCommand(input);
        }

        this.logger = new MessageLogger(this.appenders.toArray(new Appender[this.appenders.size()]));

        while (true) {
            String[] input = Console.readLine().split("\\|");
            if("END".equals(input[0]))
                break;

            execLogCommand(input);
        }

        System.out.println(logger.printStatistics());
    }

    private void execLogCommand(String[] data) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String commandName = Character.toUpperCase(data[0].charAt(0)) + data[0].substring(1).toLowerCase() + "LogCommand";
        Class<?> commandClass = Class.forName(COMMAND_PATH + commandName);

        Executable executable = getExecutable(commandClass);
        this.injectParms(executable);
        executable.execute(data);
    }

    private void execAppenderCommand(String[] data) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> commandClass = ParseAppenderCommand.class;

        Executable executable = getExecutable(commandClass);
        this.injectParms(executable);
        executable.execute(data);
    }

    private Executable getExecutable(Class<?> commandClass) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Constructor<?> commandConstructor = commandClass.getConstructor();
        return (Executable) commandConstructor.newInstance();
    }

    private void injectParms(Executable executable) throws IllegalAccessException {
        for (Field field : executable.getClass().getDeclaredFields()) {
            if(field.isAnnotationPresent(Inject.class)) {
                for (Field fieldToInject : this.getClass().getDeclaredFields()) {
                    if(field.getType().equals(fieldToInject.getType())) {
                        field.setAccessible(true);
                        fieldToInject.setAccessible(true);
                        field.set(executable, fieldToInject.get(this));
                    }
                }
            }
        }
    }
}
