import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.List;

public class Main {

    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        EntityManagerFactory soft_uni = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = soft_uni.createEntityManager();

        exSix(em);

        exThree(em);
        exFour(em);
    }

    private static void exSix(EntityManager em) throws IOException {
        em.getTransaction().begin();

        String lastName = reader.readLine();
        List<Employee> employees = em.createQuery("SELECT address FROM Employee WHERE lastName = :lastName", Employee.class)
                .setParameter("lastName", lastName)
                .getResultList();

        Address vitoshka = new Address();
        vitoshka.setText("Vitoshka 15");

        for (Employee employee : employees) {
            employee.setAddress(vitoshka);
        }
        em.getTransaction().commit();
        em.close();
    }

    private static void exFour(EntityManager em) throws IOException {
        BigDecimal minSalary = new BigDecimal(reader.readLine());

        em.getTransaction().begin();
        List<String> employees = em.createQuery("SELECT firstName FROM Employee WHERE salary > :salary", String.class)
                .setParameter("salary", minSalary)
                .getResultList();

        for (String fName: employees) {
            System.out.println(fName);
        }

        em.close();
    }

    private static void exThree(EntityManager em) throws IOException {
        String employeeName = reader.readLine();


        em.getTransaction().begin();

        TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e WHERE CONCAT(e.firstName ,' ', e.lastName) = :name ", Employee.class);

        List<Employee> employeeList = query.setParameter("name", employeeName).getResultList();

        if (employeeList.isEmpty()) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
        em.close();
    }
}
