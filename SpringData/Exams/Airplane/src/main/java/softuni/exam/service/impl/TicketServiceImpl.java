package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.TicketSeedRootDto;
import softuni.exam.models.entities.Ticket;
import softuni.exam.repository.TicketRepository;
import softuni.exam.service.PassengerService;
import softuni.exam.service.PlaneService;
import softuni.exam.service.TicketService;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class TicketServiceImpl implements TicketService {

    private static final String TICKETS_FILE_PATH = "src/main/resources/files/xml/tickets.xml";

    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final TicketRepository ticketRepository;
    private final XmlParser xmlParser;
    private final TownService townService;
    private final PlaneService planeService;
    private final PassengerService passengerService;

    public TicketServiceImpl(ModelMapper modelMapper, ValidationUtil validationUtil, TicketRepository ticketRepository, XmlParser xmlParser, TownService townService, PlaneService planeService, PassengerService passengerService) {
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.ticketRepository = ticketRepository;
        this.xmlParser = xmlParser;
        this.townService = townService;
        this.planeService = planeService;
        this.passengerService = passengerService;
    }

    @Override
    public boolean areImported() {
        return ticketRepository.count() > 0;
    }

    @Override
    public String readTicketsFileContent() throws IOException {
        return Files.readString(Path.of(TICKETS_FILE_PATH));
    }

    @Override
    public String importTickets() throws JAXBException, IOException {
        StringBuilder sb = new StringBuilder();

        TicketSeedRootDto ticketSeedRootDto = xmlParser.fromXml(TICKETS_FILE_PATH, TicketSeedRootDto.class);


        ticketSeedRootDto.getTickets().stream()
                .filter(ticket -> {
                    boolean isValid = validationUtil.isValid(ticket);

                    sb.append(isValid ? String.format("Successfully imported Ticket %s - %s",
                            ticket.getFromTown().getName(), ticket.getToTown().getName())
                            :
                            "Invalid ticket").append(System.lineSeparator());

                    return isValid;
                })
                .map(ticket -> {
                    Ticket mappedTicket = modelMapper.map(ticket, Ticket.class);

                    mappedTicket.setFromTown(townService.getRandomTown(ticket.getFromTown().getName()));
                    mappedTicket.setToTown(townService.getRandomTown(ticket.getToTown().getName()));
                    mappedTicket.setPlane(planeService.getPlane(ticket.getPlane().getRegisterNumber()));
                    mappedTicket.setPassenger(passengerService.getPassenger(ticket.getPassenger().getEmail()));

                    return mappedTicket;
                })
                .forEach(ticketRepository::save);

        return sb.toString();
    }
}
