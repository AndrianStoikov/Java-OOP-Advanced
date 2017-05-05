package Logger.models.layouts;

import Logger.enums.ReportLevel;
import Logger.interfaces.Layout;

public class XmlLayout implements Layout {
    private StringBuilder stringBuilder;

    public XmlLayout() {
        this.stringBuilder = new StringBuilder();
    }

    @Override
    public String appendMessage(String dateAndTime, String message, ReportLevel level) {
        this.stringBuilder.setLength(0);
        this.stringBuilder.append("<log>").append(System.lineSeparator());
        this.stringBuilder.append(String.format("    <date>%s</date>", dateAndTime)).append(System.lineSeparator());
        this.stringBuilder.append(String.format("    <level>%s</level>", level)).append(System.lineSeparator());
        this.stringBuilder.append(String.format("    <message>%s</message>", message)).append(System.lineSeparator());
        this.stringBuilder.append("</log>");
        return this.stringBuilder.toString();
    }
}
