package bg.softuni.hateoas.model.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class OrderEntity extends BaseEntity {

    private StudentEntity student;
    private CourseEntity courses;

    public OrderEntity() {
    }

    @ManyToOne
    public StudentEntity getStudent() {
        return student;
    }

    public OrderEntity setStudent(StudentEntity student) {
        this.student = student;
        return this;
    }

    @ManyToOne
    public CourseEntity getCourses() {
        return courses;
    }

    public OrderEntity setCourses(CourseEntity courseEntity) {
        this.courses = courseEntity;
        return this;
    }
}
