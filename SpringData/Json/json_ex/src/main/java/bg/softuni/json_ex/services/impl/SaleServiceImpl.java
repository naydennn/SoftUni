package bg.softuni.json_ex.services.impl;

import bg.softuni.json_ex.models.dtos.SeedDtos.SaleSeedDto;
import bg.softuni.json_ex.models.entities.Car;
import bg.softuni.json_ex.models.entities.Customer;
import bg.softuni.json_ex.models.entities.Sale;
import bg.softuni.json_ex.repositories.SaleRepository;
import bg.softuni.json_ex.services.CarService;
import bg.softuni.json_ex.services.CustomerService;
import bg.softuni.json_ex.services.SaleService;
import bg.softuni.json_ex.utils.ValidatorUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class SaleServiceImpl implements SaleService {

    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidatorUtil validatorUtil;
    private final SaleRepository saleRepository;
    private final CarService carService;
    private final CustomerService customerService;

    public SaleServiceImpl(ModelMapper modelMapper, Gson gson, ValidatorUtil validatorUtil, SaleRepository saleRepository, CarService carService, CustomerService customerService) {
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validatorUtil = validatorUtil;
        this.saleRepository = saleRepository;
        this.carService = carService;
        this.customerService = customerService;
    }

    @Override
    public void seedData() throws IOException {
        if (saleRepository.count() == 0) {
            List<Car> cars = carService.getAllCar();
            List<Customer> customers = customerService.getAllCustomers();
            List<Double> discounts = List.of(0.0, 5.0, 10.0, 15.0 , 20.0, 30.0, 40.0, 50.0);

            for (Car car : cars) {
                SaleSeedDto saleSeedDto = new SaleSeedDto();

                int randomIndexCar = ThreadLocalRandom.current().nextInt(1, cars.size());
                int randomIndexCustomer = ThreadLocalRandom.current().nextInt(1, customers.size());
                int randomIndexDiscount = ThreadLocalRandom.current().nextInt(1, discounts.size());

                saleSeedDto.setCar(cars.get(randomIndexCar));
                saleSeedDto.setCustomer(customers.get(randomIndexCustomer));
                saleSeedDto.getDiscountPercentage(discounts.get(randomIndexDiscount));

                Sale sale = modelMapper.map(saleSeedDto, Sale.class);
                sale.setDiscountPercentage(discounts.get(randomIndexDiscount));

                saleRepository.save(sale);
            }
        }
    }
}
