package bg.softuni.events;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class TestController {

    private final ApplicationEventPublisher applicationEventPublisher;

    public TestController(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @GetMapping("/create-order")
    public String getEvent() {

        OrderCreatedEvent order = new OrderCreatedEvent(this, UUID.randomUUID().toString());

        applicationEventPublisher.publishEvent(order);

        return "test";
    }
}
