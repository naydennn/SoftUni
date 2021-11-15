package bg.softuni.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FixedRateScheduler {

    private static final Logger LOGGER = LoggerFactory.getLogger(CronSchedulerDemo.class);


    @Scheduled(fixedRate = 5000)
    public void showTimeWithFixedRateScheduler() {
        LOGGER.info("Hello from fixed rate scheduler " + LocalDateTime.now());
    }
}
