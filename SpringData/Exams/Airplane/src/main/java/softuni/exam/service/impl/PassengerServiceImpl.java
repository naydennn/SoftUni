package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.PassengerSeedDto;
import softuni.exam.models.entities.Passenger;
import softuni.exam.repository.PassengerRepository;
import softuni.exam.service.PassengerService;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class PassengerServiceImpl implements PassengerService {

    private static final String PASSENGER_FILE_PATH = "src/main/resources/files/json/passengers.json";

    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final PassengerRepository passengerRepository;
    private final Gson gson;
    private final TownService townService;

    public PassengerServiceImpl(ModelMapper modelMapper, ValidationUtil validationUtil, PassengerRepository passengerRepository, Gson gson, TownService townService) {
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.passengerRepository = passengerRepository;
        this.gson = gson;
        this.townService = townService;
    }

    @Override
    public boolean areImported() {
        return passengerRepository.count() > 0;
    }

    @Override
    public String readPassengersFileContent() throws IOException {
        return Files.readString(Path.of(PASSENGER_FILE_PATH));
    }

    @Override
    public String importPassengers() throws IOException {

        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readPassengersFileContent(), PassengerSeedDto[].class))
                .filter(passenger -> {
                    boolean isValid = validationUtil.isValid(passenger);

                    sb.append(isValid ? String.format("Successfully imported Passenger %s - %s",
                            passenger.getLastName(), passenger.getEmail()) : "Invalid passenger")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(passenger -> {
                    Passenger mappedPassenger = modelMapper.map(passenger, Passenger.class);

                    mappedPassenger.setTown(townService.getRandomTown(passenger.getTown()));

                    return mappedPassenger;
                })
                        .forEach(passengerRepository::save);
        return sb.toString();
    }

    @Override
    public String getPassengersOrderByTicketsCountDescendingThenByEmail() {
        StringBuilder sb = new StringBuilder();

        passengerRepository.getAllPassengerOrderByTicketsSizeDescThenByEmail()
                .forEach(passenger -> {
                    sb.append(String.format("Passenger %s  %s\n" +
                            "\tEmail - %s\n" +
                            "Phone - %s\n" +
                            "\tNumber of tickets - %d\n",
                            passenger.getFirstName(), passenger.getLastName(),
                            passenger.getEmail(), passenger.getPhoneNumber(), passenger.getTickets().size()));
                });

        return sb.toString();
    }

    @Override
    public Passenger getPassenger(String email) {
        return passengerRepository.findByEmail(email);
    }
}
