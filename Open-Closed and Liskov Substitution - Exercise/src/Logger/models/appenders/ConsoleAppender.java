package Logger.models.appenders;

import Logger.enums.ReportLevel;
import Logger.interfaces.Appender;
import Logger.interfaces.Layout;


public class ConsoleAppender extends AbstractAppender {
    private Layout layout;
    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void append(String dateAndTime, String message, ReportLevel level) {
        if (this.getLevel().compareTo(level) <= 0) {
            String messageResult = this.getLayout().appendMessage(dateAndTime, message, level);
            System.out.println(messageResult);
            this.increaseAppendedMessages();
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
