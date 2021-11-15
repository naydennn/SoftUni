package bg.softuni.events.orderListener;


import bg.softuni.events.OrderCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class BonusPointGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(BonusPointGenerator.class);

    @EventListener(OrderCreatedEvent.class)
    public void onCreateOrder(OrderCreatedEvent orderCreatedEvent){
        LOGGER.info("Add bonus points !!" + orderCreatedEvent.getOrderId());
    }
}
