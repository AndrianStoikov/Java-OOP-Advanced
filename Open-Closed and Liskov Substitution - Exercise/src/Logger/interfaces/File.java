package Logger.interfaces;

import Logger.enums.ReportLevel;

public interface File {
    void write(String message);

    int getSize();
}
