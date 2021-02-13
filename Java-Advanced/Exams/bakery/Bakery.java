package bakery;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bakery {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public int getCount() {
        return this.employees.size();
    }

    public void add(Employee employee) {
        if (getCount() < capacity) {
            employees.add(employee);
        }
    }

    public boolean remove(String name) {
        return employees.removeIf(employee -> employee.getName().equals(name));
    }

    public Employee getOldestEmployee() {
        return employees.stream().max(Comparator.comparingInt(Employee::getAge)).get();
    }

    public Employee getEmployee(String name) {
        return employees.stream().filter(a -> a.getName().equals(name)).findFirst().get();
    }

    public String report() {
        StringBuilder result = new StringBuilder();
        result.append("Employees working at Bakery ").append(this.name).append(":").append(System.lineSeparator());
        this.employees.forEach(a->result.append(a).append(System.lineSeparator()));
        return result.toString();
    }
}

