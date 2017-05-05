package Logger.interfaces;

public interface Logger {
    void logError(String dateAndTime, String message);

    void logInfo(String dateAndTime, String message);

    void logWarning(String dateAndTime, String message);

    void logCritical(String dateAndTime, String message);

    void logFatal(String dateAndTime, String message);

    String printStatistics();
}
