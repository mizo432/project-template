package com.undecided.projectTemplate.example.timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class AnyTimerTask {

    private static final Logger LOG = LoggerFactory.getLogger(AnyTimerTask.class);

    /**
     * 10分(600000ms)毎に起動される
     */
    @Scheduled(fixedRate = 600000)
    public void execute() {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        LOG.info("The time is now {}", dateFormat.format(new Date()));

    }
}
