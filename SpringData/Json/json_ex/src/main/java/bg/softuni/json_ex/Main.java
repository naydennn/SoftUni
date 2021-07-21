package bg.softuni.json_ex;

import bg.softuni.json_ex.services.*;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;

import static bg.softuni.json_ex.constraints.GlobalConstraints.FILE_OUTPUT_PATH;

@Component
public class Main implements CommandLineRunner {

    public static final String ORDERED_CUSTOMERS_JSON = "ordered-customers.json";
    public static final String TOYOTA_CARS_JSON = "toyota-cars.json";
    public static final String CARS_AND_PARTS_JSON = "cars-and-parts.json";

    private final SupplierService supplierService;
    private final PartServices partServices;
    private final CustomerService customerService;
    private final CarService carService;
    private final SaleService saleService;
    private final Gson gson;

    public Main(SupplierService supplierService, PartServices partServices, CustomerService customerService, CarService carService, SaleService saleService, Gson gson) {
        this.supplierService = supplierService;
        this.partServices = partServices;
        this.customerService = customerService;
        this.carService = carService;
        this.saleService = saleService;
        this.gson = gson;
    }


    @Override
    public void run(String... args) throws Exception {
        seedData();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please choose exercises number");
        int exNum = Integer.parseInt(reader.readLine());

        switch (exNum) {
            case 1 -> orderedCustomers();
            case 2 -> getToyotaCar();
            case 3-> localSuppliers();
            case 4 -> carsWithTheirListOfParts();
        }
    }

    private void localSuppliers() {
        System.out.println("This exercises not working for now :(");
        supplierService.getLocalSupplierWithParts();
    }

    private void carsWithTheirListOfParts() throws IOException {
        writeToFile(FILE_OUTPUT_PATH + CARS_AND_PARTS_JSON,
                gson.toJson(carService.getAllCarsWithTheirParts()));
    }

    private void getToyotaCar() throws IOException {
        writeToFile(FILE_OUTPUT_PATH + TOYOTA_CARS_JSON,
                gson.toJson(carService.getAllCarByToyota("Toyota")));
    }

    private void orderedCustomers() throws IOException {
        String writer = gson.toJson(customerService.getAllCustomersOrderedByBirthDate());

        writeToFile(FILE_OUTPUT_PATH + ORDERED_CUSTOMERS_JSON, writer);
    }

    private void seedData() throws IOException {
        supplierService.seedData();
        partServices.seedData();
        customerService.seedData();
        carService.seedData();
        saleService.seedData();
    }

    private void writeToFile(String path, String content) throws IOException {
        Files.write(Path.of(path), Collections.singleton(content));
    }
}
