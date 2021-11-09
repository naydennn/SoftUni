package bg.softuni.hateoas.model.mapping;

import bg.softuni.hateoas.model.dto.OrderDTO;
import bg.softuni.hateoas.model.entity.CourseEntity;
import bg.softuni.hateoas.model.entity.OrderEntity;
import bg.softuni.hateoas.model.entity.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(source = "courses", target = "courseId", qualifiedByName = "getCourseId")
    @Mapping(source = "student", target = "studentId", qualifiedByName = "getStudentId")
    OrderDTO mapOrderToOrderDto(OrderEntity order);

    @Named("getCourseId")
    default Long getCourseId(CourseEntity course) {
        return course.getId();
    }

    @Named("getStudentId")
    default Long getCourseId(StudentEntity student) {
        return student.getId();
    }
}
