package Logger.interfaces;

import Logger.enums.ReportLevel;

/**
 * Created by Andrian on 5.4.2017 г..
 */
public interface Layout {
    String appendMessage(String dateAndTime, String message, ReportLevel level);
}
