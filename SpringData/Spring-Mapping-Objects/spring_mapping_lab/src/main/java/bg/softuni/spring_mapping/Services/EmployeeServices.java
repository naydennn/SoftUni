package bg.softuni.spring_mapping.Services;

import bg.softuni.spring_mapping.models.dto.EmployeeDto;
import bg.softuni.spring_mapping.models.dto.ManagerDto;

import java.util.List;

public interface EmployeeServices {

    EmployeeDto findOne(Long id);

    List<ManagerDto> findAll();
}
