package bg.softuni.hateoas.service;

import bg.softuni.hateoas.model.dto.StudentDTO;

public interface StudentService {

    StudentDTO findById(Long id);
}
