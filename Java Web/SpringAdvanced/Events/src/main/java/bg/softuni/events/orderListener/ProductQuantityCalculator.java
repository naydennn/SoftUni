package bg.softuni.events.orderListener;

import bg.softuni.events.OrderCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ProductQuantityCalculator {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductQuantityCalculator.class);

    @EventListener(OrderCreatedEvent.class)
    public void onCreateOrder(OrderCreatedEvent orderCreatedEvent){

        LOGGER.info("Create quantity calculator event " + orderCreatedEvent.getOrderId());
    }
}
