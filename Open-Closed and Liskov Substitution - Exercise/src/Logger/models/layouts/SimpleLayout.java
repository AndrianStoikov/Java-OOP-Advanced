package Logger.models.layouts;

import Logger.enums.ReportLevel;
import Logger.interfaces.Layout;

public class SimpleLayout implements Layout {

    public SimpleLayout() {
    }

    @Override
    public String appendMessage(String dateAndTime, String message, ReportLevel level) {
        return String.format("%s - %s - %s", dateAndTime, level, message);
    }
}
