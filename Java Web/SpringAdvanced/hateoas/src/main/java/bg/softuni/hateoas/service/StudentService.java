package bg.softuni.hateoas.service;

import bg.softuni.hateoas.model.dto.StudentDTO;
import org.springframework.hateoas.EntityModel;

import java.util.List;

public interface StudentService {

    StudentDTO findById(Long id);

    List<StudentDTO> getAllStudents();
}
