import entities.Address;
import entities.Employee;
import entities.Project;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class Engine implements Runnable {

    private static EntityManager entityManager;
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public Engine(EntityManager entityManager) {
        Engine.entityManager = entityManager;
    }

    @Override
    public void run() {

        System.out.println("Please choose exercises number:");
        try {
            int exNum = Integer.parseInt(reader.readLine());
            switch (exNum) {
                case 2 -> exTwo();
                case 3 -> exThree();
                case 4 -> exFour();
                case 5 -> exFive();
                case 6 -> exSix();
                case 7 -> exSeven();
                case 8 -> exEight();
                case 9 -> exNine();
                case 10 -> exTen();
                case 11 -> exEleven();
                case 12 -> exTwelve();
                case 13 -> exThirteen();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
        }

    }

    private void exThirteen() throws IOException {

        System.out.println("Please write town:");
        String townName = reader.readLine();
        Town town = entityManager.createQuery("SELECT t FROM Town t WHERE t.name = :name", Town.class)
                .setParameter("name", townName)
                .getSingleResult();

        int affRows = removeAddressesByTownId(town.getId());

        entityManager.getTransaction().begin();
        entityManager.remove(town);
        entityManager.getTransaction().commit();

        System.out.println(affRows + " addresses in " + town.getName() + " deleted");
    }

    private int removeAddressesByTownId(Integer id) {

        List<Address> addresses = entityManager.createQuery("SELECT a FROM Address a WHERE a.town.id = :id", Address.class)
                .setParameter("id", id)
                .getResultList();

        entityManager.getTransaction().begin();
        for (Address a : addresses) {
            entityManager.remove(a);
        }
        entityManager.getTransaction().commit();
        return addresses.size();
    }

    private void exTwelve() {
        for (String department : entityManager.createQuery("SELECT CONCAT(e.department.name, ' ', MAX(e.salary)) FROM Employee e " +
                "GROUP BY e.department.name " +
                "HAVING MAX(e.salary) < 30000 OR MAX(e.salary) > 70000", String.class)
                .getResultList()) {
            System.out.println(department);
        }
    }

    private void exEleven() throws IOException {

        System.out.println("Please write pattern:");
        String pattern = reader.readLine();
        pattern += "%";
        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e WHERE e.firstName LIKE :pattern", Employee.class)
                .setParameter("pattern", pattern).getResultList();

        employees.forEach(e -> System.out.printf("%s - %s - ($%.2f)%n", e.getFirstName(), e.getLastName(), e.getSalary()));
    }

    private void exTen() {

        Set<Integer> ids = Set.of(1, 2, 4, 11);
        entityManager.getTransaction().begin();
        entityManager.createQuery("UPDATE Employee e SET e.salary = e.salary * 1.12 " +
                "WHERE e.department.id IN :ids").setParameter("ids", ids).executeUpdate();

        entityManager.getTransaction().commit();

        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e WHERE e.department.id IN :ids", Employee.class)
                .setParameter("ids", ids)
                .getResultList();

        employees.forEach(e -> System.out.printf("%s %s ($%.2f)%n", e.getFirstName(), e.getLastName(), e.getSalary()));
    }

    private void exNine() {
        entityManager.createQuery("SELECT p FROM Project p ORDER BY p.startDate DESC, p.name", Project.class)
                .setMaxResults(10)
                .getResultList()
                .forEach(p -> System.out.printf("Project name: %s%n" +
                                "      Project Description: %s%n" +
                                "      Project Start Date: %s%n" +
                                "      Project End Date: %s%n",
                        p.getName(), p.getDescription(), p.getStartDate().atZone(ZoneId.systemDefault()), p.getEndDate()));
    }

    private void exEight() throws IOException {

        System.out.println("Please enter ID for employee");
        int id = Integer.parseInt(reader.readLine());

        Employee employee = entityManager.find(Employee.class, id);

        System.out.printf("%s %s - %s%n", employee.getFirstName(), employee.getLastName(),
                employee.getJobTitle());
        employee.getProjects().stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(p -> System.out.println("    " + p.getName()));
    }

    private void exSeven() {
        List<Address> addresses = entityManager.createQuery("SELECT a FROM Address a ORDER BY a.employees.size DESC", Address.class)
                .setMaxResults(10)
                .getResultList();

        for (Address a : addresses) {
            System.out.printf("%s, %s - %d%n", a.getText(),
                    a.getTown() == null ? "Unknown" : a.getTown().getName(),
                    a.getEmployees().size());
        }
    }

    private void exTwo() {

        entityManager.getTransaction().begin();
        System.out.println("Updated towns name:");
        System.out.printf("%d", entityManager
                .createQuery("UPDATE Town t SET t.name = upper(t.name) WHERE LENGTH(t.name) > 5")
                .executeUpdate());

        entityManager.getTransaction().commit();
    }

    private static void exThree() throws IOException {

        System.out.println("Please write full name of employee separated by space:");
        String[] employeeName = reader.readLine().split("\\s+");

        TypedQuery<Employee> query = entityManager
                .createQuery("SELECT e FROM Employee e WHERE CONCAT(e.firstName ,' ', e.lastName) = :name "
                        , Employee.class);

        List<Employee> employeeList = query.setParameter("name", employeeName[0] + " " + employeeName[1]).getResultList();

        if (employeeList.isEmpty()) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }

    }

    private static void exFour() throws IOException {

        System.out.println("Please select min salary:");
        BigDecimal minSalary = new BigDecimal(reader.readLine());

        List<String> employees = entityManager.createQuery("SELECT firstName FROM Employee WHERE salary > :salary", String.class)
                .setParameter("salary", minSalary)
                .getResultList();

        for (String fName : employees) {
            System.out.println(fName);
        }

    }

    private void exFive() {

        entityManager.createQuery("SELECT e FROM Employee e WHERE e.department.name = :dName ORDER BY e.salary, e.id", Employee.class)
                .setParameter("dName", "Research and Development")
                .getResultList()
                .forEach(e -> System.out.printf("%s %s %s - $%.2f%n", e.getFirstName(),
                        e.getLastName(), e.getDepartment().getName(), e.getSalary()));
    }

    private static void exSix() throws IOException {

        System.out.println("Please write last name for employee to set new address:");
        String lastName = reader.readLine();
        Employee employee = entityManager.createQuery("SELECT e FROM Employee e WHERE e.lastName = :lastName", Employee.class)
                .setParameter("lastName", lastName)
                .getSingleResult();

        Address address = createAddress("Vitoshka 15",
                null);

        entityManager.getTransaction().begin();
        employee.setAddress(address);
        entityManager.getTransaction().commit();
    }

    private static Address createAddress(String text, Town town) {
        entityManager.getTransaction().begin();
        Address address = new Address();
        address.setText(text);
        address.setTown(town);

        entityManager.persist(address);
        entityManager.getTransaction().commit();
        return address;
    }

}
