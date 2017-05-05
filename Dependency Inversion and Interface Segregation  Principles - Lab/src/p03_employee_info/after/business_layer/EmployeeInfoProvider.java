package p03_employee_info.after.business_layer;

import p03_employee_info.after.user_interface.InfoProvider;
import p03_employee_info.after.models.Employee;

import java.util.Comparator;
import java.util.stream.Collectors;

public class EmployeeInfoProvider implements InfoProvider<Employee> {

    private EmployeeDatabase database;

    public EmployeeInfoProvider(EmployeeDatabase database) {
        this.database = database;
    }

    public Iterable<Employee> getBy(Comparator<Employee> comparator) {
        return this.database.readEmployees().stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}
