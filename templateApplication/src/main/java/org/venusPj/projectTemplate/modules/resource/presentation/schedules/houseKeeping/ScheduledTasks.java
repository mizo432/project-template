package org.venusPj.projectTemplate.modules.resource.presentation.schedules.houseKeeping;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    @Scheduled(cron = "0 * * * * *")
    public void doSomething() {
        //nop
    }

}
