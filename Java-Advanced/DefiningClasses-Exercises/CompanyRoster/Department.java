package CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    String name;
    List<Employee> employees;

    public Department (String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public String getName() {
        return name;
    }

    public double getAverageSalary() {
        return this.employees.stream()
                .mapToDouble(Employee::getSalary).average().orElse(0.0);
    }
}
