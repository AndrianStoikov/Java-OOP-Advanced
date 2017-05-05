package logger;

import writers.Writer;

public class EventLogger extends Logger{

    private Writer writer;

    public EventLogger(Writer writer) {
        this.writer = writer;
    }

    @Override
    public void handle(LogType type, String message) {
        if (type == LogType.EVENT) {
            this.writer.println(String.format("%s: %s", type, message));
        } else
            this.passToSuccessor(type, message);
    }
}
