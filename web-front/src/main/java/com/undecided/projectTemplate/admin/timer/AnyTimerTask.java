package com.undecided.projectTemplate.admin.timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class AnyTimerTask {

    private static final Logger LOG = LoggerFactory.getLogger(AnyTimerTask.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    void execute() {
        LOG.info("The time is now {}", dateFormat.format(new Date()));
    }
}
