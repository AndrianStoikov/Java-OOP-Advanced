package Logger.models.appenders;

import Logger.enums.ReportLevel;
import Logger.interfaces.Appender;
import Logger.interfaces.Layout;

public abstract class AbstractAppender implements Appender {
    private Layout layout;
    private ReportLevel level;
    private int appendedMessages;

    protected AbstractAppender(Layout layout) {
        this.layout = layout;
        this.appendedMessages = 0;
    }

    protected Layout getLayout() {
        return this.layout;
    }

    protected ReportLevel getLevel() {
        return level;
    }

    @Override
    public void setReportLevel(ReportLevel level) {
        this.level = level;
    }

    protected void increaseAppendedMessages() {
        this.appendedMessages++;
    }

    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d",
                this.getClass().getSimpleName(),
                this.layout.getClass().getSimpleName(),
                this.level,
                this.appendedMessages);
    }
}
