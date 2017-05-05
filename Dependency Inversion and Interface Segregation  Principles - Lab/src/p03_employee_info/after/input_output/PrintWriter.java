package p03_employee_info.after.input_output;

import p03_employee_info.after.user_interface.Formatter;
import p03_employee_info.after.user_interface.Writer;

import java.io.PrintStream;

public class PrintWriter implements Writer, Formatter {

    private PrintStream output;

    public PrintWriter(PrintStream output) {
        this.output = output;
    }

    public void println(String message) {
        this.output.println(message);
    }

    public <T> String format(Iterable<T> items) {
        StringBuilder sb = new StringBuilder();
        for (T item : items) {
            sb.append(item).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
