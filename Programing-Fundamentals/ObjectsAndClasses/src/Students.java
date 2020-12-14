
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> students = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] arrays = input.split(" ");

            Student s = new Student(arrays[0], arrays[1], Integer.parseInt(arrays[2]), arrays[3]);
            int existingIndex = findExistingIndex(students, s.getName(), s.getLastName());
            if (existingIndex != -1) {
                students.get(existingIndex).setAge(s.age);
                students.get(existingIndex).setCity(s.city);
            } else {
                students.add(s);
            }
            input = scanner.nextLine();
        }
        String searchCity = scanner.nextLine();

        for (Student student : students) {
            if (student.getCity().equals(searchCity)) {
                System.out.printf("%s %s is %d years old%n", student.getName(), student.getLastName(), student.getAge());
            }
        }
    }

    private static int findExistingIndex(List<Student> students, String name, String lastName) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(name) &&
                    students.get(i).getLastName().equals(lastName)) {
                return i;
            }
        }
        return -1;
    }

    public static class Student {
        String name;
        String lastName;
        int age;
        String city;

        Student(String name, String lastName, int age, String city) {
            this.name = name;
            this.lastName = lastName;
            this.age = age;
            this.city = city;
        }

        public String getName() {
            return name;
        }

        public String getLastName() {
            return lastName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCity() {
            return city;
        }
    }
}
