package bg.softuni.json_ex.services.impl;

import bg.softuni.json_ex.models.dtos.SeedDtos.CustomerSeedDto;
import bg.softuni.json_ex.models.dtos.View.OrderedCustomersView;
import bg.softuni.json_ex.models.entities.Customer;
import bg.softuni.json_ex.repositories.CustomerRepository;
import bg.softuni.json_ex.services.CustomerService;
import bg.softuni.json_ex.utils.ValidatorUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static bg.softuni.json_ex.constraints.GlobalConstraints.FILE_INPUT_PATH;

@Service
public class CustomerServiceImpl implements CustomerService {

    public static final String FILE_NAME = "customers.json";

    private final ModelMapper modelMapper;
    private final Gson gson;
    private final CustomerRepository customerRepository;
    private final ValidatorUtil validatorUtil;

    public CustomerServiceImpl(ModelMapper modelMapper, Gson gson, CustomerRepository customerRepository, ValidatorUtil validatorUtil) {
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.customerRepository = customerRepository;
        this.validatorUtil = validatorUtil;
    }

    @Override
    public void seedData() throws IOException {

        if (customerRepository.count() == 0) {
            String content = Files.readString(Path.of(FILE_INPUT_PATH + FILE_NAME));

            Arrays.stream(gson.fromJson(content, CustomerSeedDto[].class))
                    .filter(validatorUtil::isValid)
                    .map(customerSeedDto -> modelMapper.map(customerSeedDto, Customer.class))
                    .forEach(customerRepository::save);
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.getAllBy();
    }

    @Override
    public List<OrderedCustomersView> getAllCustomersOrderedByBirthDate() {

         return customerRepository.getAllByBirthdate().stream()
                .map(customer -> modelMapper.map(customer, OrderedCustomersView.class))
                .collect(Collectors.toList());
    }
}
