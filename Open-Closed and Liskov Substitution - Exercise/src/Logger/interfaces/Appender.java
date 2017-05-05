package Logger.interfaces;

import Logger.enums.ReportLevel;

/**
 * Created by Andrian on 5.4.2017 г..
 */
public interface Appender {
    void append(String dateAndTime, String message, ReportLevel level);

    void setReportLevel(ReportLevel level);
}
