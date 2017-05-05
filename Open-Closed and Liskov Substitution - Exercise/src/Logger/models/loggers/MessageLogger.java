package Logger.models.loggers;

import Logger.enums.ReportLevel;
import Logger.interfaces.Appender;
import Logger.interfaces.Logger;

public class MessageLogger implements Logger {
    private Appender[] appenders;

    public MessageLogger(Appender... appenders) {
        this.appenders = appenders;
    }

    @Override
    public void logError(String dateAndTime, String message) {
        ReportLevel level = ReportLevel.ERROR;
        this.log(dateAndTime, message, level);
    }

    @Override
    public void logInfo(String dateAndTime, String message) {
        ReportLevel level = ReportLevel.INFO;
        this.log(dateAndTime, message, level);
    }

    @Override
    public void logWarning(String dateAndTime, String message) {
        ReportLevel level = ReportLevel.WARNING;
        this.log(dateAndTime, message, level);
    }

    @Override
    public void logCritical(String dateAndTime, String message) {
        ReportLevel level = ReportLevel.CRITICAL;
        this.log(dateAndTime, message, level);
    }

    @Override
    public void logFatal(String dateAndTime, String message) {
        ReportLevel level = ReportLevel.FATAL;
        this.log(dateAndTime, message, level);
    }

    @Override
    public String printStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("Logger info").append(System.lineSeparator());
        for (Appender appender : this.appenders) {
            sb.append(appender.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }

    private void log(String dateAndTime, String message, ReportLevel level) {
        for (Appender appender : this.appenders) {
            appender.append(dateAndTime, message, level);
        }
    }
}
