package Logger;

import Logger.interfaces.Logger;
import Logger.interfaces.Runable;
import Logger.models.loggers.MessageLogger;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
    @SuppressWarnings("SpellCheckingInspection")
    public static void main(String[] args) throws IOException, NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Logger logger = new MessageLogger();
        Runable engine = new Engine(logger);
        engine.run();

    }
}
