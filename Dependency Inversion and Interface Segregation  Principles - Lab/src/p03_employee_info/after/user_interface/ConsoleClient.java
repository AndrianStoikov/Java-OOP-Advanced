package p03_employee_info.after.user_interface;

import p03_employee_info.after.models.Employee;

public class ConsoleClient {

    private InfoProvider<Employee> infoProvider;
    private Writer writer;
    private Formatter formatter;

    public ConsoleClient(InfoProvider<Employee> infoProvider, Writer writer, Formatter formatter) {
        this.infoProvider = infoProvider;
        this.writer = writer;
        this.formatter = formatter;
    }

    public void run() {
        Iterable<Employee> employeesByName = this.infoProvider.getBy((e1, e2) -> e1.getName().compareTo(e2.getName()));
        String output = this.formatter.format(employeesByName);
        this.writer.println(output);
    }
}
