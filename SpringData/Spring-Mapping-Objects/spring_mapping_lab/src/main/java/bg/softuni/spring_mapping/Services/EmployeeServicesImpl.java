package bg.softuni.spring_mapping.Services;

import bg.softuni.spring_mapping.Repositories.EmployeeRepository;
import bg.softuni.spring_mapping.models.dto.EmployeeDto;
import bg.softuni.spring_mapping.models.dto.ManagerDto;
import bg.softuni.spring_mapping.models.entities.Employee;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServicesImpl implements EmployeeServices {

    private final EmployeeRepository employeeRepository;

    private final ModelMapper modelMapper;

    public EmployeeServicesImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public EmployeeDto findOne(Long id) {

        return modelMapper.map(employeeRepository.findById(id).orElseThrow(), EmployeeDto.class);

    }

    @Override
    public List<ManagerDto> findAll() {
        return modelMapper.map(employeeRepository.findAll(), new TypeToken<List<ManagerDto>>() {}.getType());
    }
}
