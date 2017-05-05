package p03_employee_info.after.business_layer;

import p03_employee_info.after.models.Employee;

import java.util.List;

public interface EmployeeDatabase {
    List<Employee> readEmployees();
}
