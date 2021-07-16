package bg.softuni.spring_mapping.configs;

import bg.softuni.spring_mapping.models.dto.EmployeeDto;
import bg.softuni.spring_mapping.models.dto.ManagerDto;
import bg.softuni.spring_mapping.models.entities.Employee;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addMappings(new PropertyMap<Employee, EmployeeDto>() {
            @Override
            protected void configure() {
                map().setSalary(source.getIncome());
            }
        });

        return modelMapper;
    }
}
