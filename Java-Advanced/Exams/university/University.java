package university;

import java.util.ArrayList;
import java.util.List;

public class University {

    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        if (capacity > this.students.size()) {
            if (this.students.contains(student)) {
                return "Student is already in the university";
            } else {
                this.students.add(student);
                return String.format("Added student %s %s", student.getFirstName(), student.getLastName());
            }
        }
        return "No seats in the university";
    }

    public String dismissStudent(Student student) {
        if (students.remove(student)) {
            return String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
        }

        return "Student not found";
    }

    public Student getStudent(String firstName, String lastName) {

        Student stu = null;
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) &&
                    student.getLastName().equals(lastName)) {
                stu = student;
            }
        }
        return stu;
    }

    public String getStatistics() {
        StringBuilder result = new StringBuilder();

        for (Student student : students) {
            result.append("==Student: First Name = ").append(student.getFirstName())
                    .append(", Last Name = ").append(student.getLastName())
                    .append(", Best Subject = ").append(student.getBestSubject())
                    .append(System.lineSeparator());
        }
        return result.toString().trim();
    }
}
