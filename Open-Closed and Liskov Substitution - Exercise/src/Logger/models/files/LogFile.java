package Logger.models.files;

import Logger.enums.ReportLevel;
import Logger.interfaces.File;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogFile implements File {
    private StringBuilder stringBuilder;

    public LogFile() {
        this.stringBuilder = new StringBuilder();
    }

    @Override
    public void write(String message) {
        this.stringBuilder.append(message).append(System.lineSeparator());
    }

    @Override
    public int getSize() {
        String str = this.stringBuilder.toString();
        String regex = "[a-zA-Z]";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);

        int sum = 0;
        while (m.find()) {
            int asciiCode = m.group().toCharArray()[0];
            sum += asciiCode;
        }
        return sum;
    }
}
