package bg.softuni.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
public class CronSchedulerDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(CronSchedulerDemo.class);

    @Scheduled(cron = "*/10 * * * * *")
    public void showTimeWithCron() {
        LOGGER.info("Hello from cron scheduler " +  LocalDateTime.now());
    }
}
