package bg.softuni.hateoas.service.impl;

import bg.softuni.hateoas.model.dto.StudentDTO;
import bg.softuni.hateoas.model.mapping.StudentMapper;
import bg.softuni.hateoas.repository.StudentRepository;
import bg.softuni.hateoas.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;


    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public StudentDTO findById(Long id) {
        return studentRepository.findById(id).
                map(studentMapper::mapEntityToDTO).
                orElseThrow();
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream().
                map(studentMapper::mapEntityToDTO).
                collect(Collectors.toList());
    }
}
