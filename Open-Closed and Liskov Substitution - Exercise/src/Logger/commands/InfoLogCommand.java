package Logger.commands;

import Logger.annotations.Inject;
import Logger.interfaces.Executable;
import Logger.interfaces.Logger;

import java.lang.reflect.InvocationTargetException;

public class InfoLogCommand implements Executable {
    @Inject
    private Logger logger;

    public InfoLogCommand() {
    }

    @Override
    public void execute(String[] data) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        logger.logInfo(data[1], data[2]);
    }
}
