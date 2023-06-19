package template.modules.resource.presentation.schedules.houseKeeping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ScheduledTasks {

    @Scheduled(cron = "0 0 0 * * *")
    public void doSomething() {
        log.info("doSomething()");
    }
}
