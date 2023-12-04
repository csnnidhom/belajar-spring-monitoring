package belajar.springmonitoring;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class MyScheduledTask {

    @Autowired
    private MeterRegistry meterRegistry;

    @Scheduled(fixedRate = 10L, timeUnit = TimeUnit.SECONDS)
    public void hello(){
        meterRegistry.counter("my.scheduled.tasks").increment();
        log.info("Hello World");
    }
}
