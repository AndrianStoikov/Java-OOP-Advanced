package logger;

import writers.Writer;

public class CombatLogger extends Logger {

    private Writer writer;

    public CombatLogger(Writer writer) {
        this.writer = writer;
    }

    @Override
    public void handle(LogType type, String message) {
        if (type == LogType.MAGIC || type == LogType.ATTACK) {
            this.writer.println(String.format("%s: %s", type, message));
        } else
            this.passToSuccessor(type, message);
    }
}
