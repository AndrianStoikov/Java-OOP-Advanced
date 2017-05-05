package Logger.models.appenders;

import Logger.enums.ReportLevel;
import Logger.interfaces.Appender;
import Logger.interfaces.File;
import Logger.interfaces.Layout;


public class FileAppender extends AbstractAppender  {
    private File file;

    public FileAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void append(String dateAndTime, String message, ReportLevel level) {
        if (this.getLevel().compareTo(level) <= 0) {
            String appendMessage = this.getLayout().appendMessage(dateAndTime, message, level);
            this.file.write(appendMessage);
            this.increaseAppendedMessages();
        }
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return super.toString() + ", File size: " +this.getSize();
    }

    private int getSize() {
        return this.file.getSize();
    }
}
