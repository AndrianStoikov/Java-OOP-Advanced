package p03_employee_info.after.data_layer;

import p03_employee_info.after.business_layer.EmployeeDatabase;
import p03_employee_info.after.models.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InMemoryEmployeeDatabase implements EmployeeDatabase {

    public List<Employee> readEmployees() {
        List<Employee> employees = new ArrayList<>();
        Collections.addAll(employees,
                new Employee("Pesho", 20),
                new Employee("Gosho", 40),
                new Employee("Angel", 15));

        return employees;
    }
}
