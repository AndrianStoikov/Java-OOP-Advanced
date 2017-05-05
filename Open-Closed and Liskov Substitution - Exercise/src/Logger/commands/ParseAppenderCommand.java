package Logger.commands;

import Logger.annotations.Inject;
import Logger.factories.AppenderFactory;
import Logger.interfaces.Appender;
import Logger.interfaces.Executable;
import Logger.models.appenders.FileAppender;
import Logger.models.files.LogFile;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class ParseAppenderCommand implements Executable {

    @Inject
    private List<Appender> logger;

    public ParseAppenderCommand() {

    }

    @Override
    public void execute(String[] data) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Appender appender = null;
        String appenderName = data[0];
        String layoutName = data[1];
        if (data.length == 3) {
            String reportLevelNamq = data[2];
            appender = AppenderFactory.createAppender(appenderName, layoutName, reportLevelNamq);
        } else {
            appender = AppenderFactory.createAppender(appenderName, layoutName);
        }

        if(appenderName.equals("FileAppender"))
            ((FileAppender) appender).setFile(new LogFile());

        this.logger.add(appender);
    }
}
