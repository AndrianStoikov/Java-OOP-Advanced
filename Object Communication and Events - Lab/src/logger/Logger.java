package logger;

public abstract class Logger implements Handler {

    private Handler handler;

    protected Logger() {
    }

    @Override
    public void setSuccessor(Handler logger) {
        this.handler = logger;
    }

    protected void passToSuccessor(LogType type, String message) {
        this.handler.handle(type, message);
    }
}
