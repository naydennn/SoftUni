package bg.softuni.spring_mapping;

import bg.softuni.spring_mapping.Services.EmployeeServicesImpl;
import bg.softuni.spring_mapping.models.dto.EmployeeDto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Main implements CommandLineRunner {

    private final EmployeeServicesImpl employeeServices;

    public Main(EmployeeServicesImpl employeeServices) {
        this.employeeServices = employeeServices;
    }

    @Override
    public void run(String... args) throws Exception {

        EmployeeDto mapEmployee = employeeServices.findOne(1L);

        System.out.println(mapEmployee.getFirstName() + " " + mapEmployee.getLastName() + " " + mapEmployee.getSalary());


        employeeServices.findAll().forEach(managerDto -> {
            System.out.println(managerDto.getFirstName() + " " +
                    managerDto.getLastName() + " | " + managerDto.getSubordinates().size());
            managerDto.getSubordinates().forEach(employee -> System.out.println("\t - " + employee.getFirstName() + " "
            + employee.getLastName() + " " + employee.getSalary()));
        });
    }
}
