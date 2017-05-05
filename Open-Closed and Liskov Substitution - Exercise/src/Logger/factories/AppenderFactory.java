package Logger.factories;

import Logger.enums.ReportLevel;
import Logger.interfaces.Appender;
import Logger.interfaces.Layout;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AppenderFactory {
    private static final String LAYOULT_PATH = "Logger.models.layouts.";
    private static final String APPENDER_PATH = "Logger.models.appenders.";

    public static Appender createAppender(String appenderName, String layoultName, String reportLevelName) throws
            ClassNotFoundException, NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        ReportLevel reportLevel = ReportLevel.valueOf(reportLevelName);
        Layout layout = createLayout(layoultName);
        return getAppender(appenderName, layout, reportLevel);
    }

    public static Appender createAppender(String typeName, String layoultName) throws ClassNotFoundException,
            NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        return AppenderFactory.createAppender(typeName, layoultName, "INFO");
    }

    private static Appender getAppender(String appenderName, Layout layout, ReportLevel reportLevel) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> appenderClass = Class.forName(APPENDER_PATH + appenderName);
        Constructor<?> appenderConstructor = appenderClass.getConstructor(Layout.class);
        Appender appender = (Appender) appenderConstructor.newInstance(layout);
        appender.setReportLevel(reportLevel);
        return appender;
    }

    private static Layout createLayout(String layoultName) throws InstantiationException, IllegalAccessException, InvocationTargetException,
            ClassNotFoundException, NoSuchMethodException {
        Class<?> layoutClass = Class.forName(LAYOULT_PATH + layoultName);
        Constructor<?> layoutConstructor = layoutClass.getConstructor();
        return (Layout) layoutConstructor.newInstance();
    }
}
