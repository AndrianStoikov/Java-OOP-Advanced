package p03_employee_info.after;

import p03_employee_info.after.business_layer.EmployeeInfoProvider;
import p03_employee_info.after.data_layer.InMemoryEmployeeDatabase;
import p03_employee_info.after.business_layer.EmployeeDatabase;
import p03_employee_info.after.input_output.PrintWriter;
import p03_employee_info.after.user_interface.ConsoleClient;

import java.io.PrintStream;

public class Main {

    public static void main(String[] args) {
        EmployeeDatabase db = new InMemoryEmployeeDatabase();
        EmployeeInfoProvider employeeInfo = new EmployeeInfoProvider(db);
        PrintWriter writer = new PrintWriter(new PrintStream(System.out));

        ConsoleClient client = new ConsoleClient(employeeInfo, writer, writer);
        client.run();
    }
}
