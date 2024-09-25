package com.danielpyld.spotware.trendbar;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Configuration
@ComponentScan
public class TrendBarConfig {

    public static final int SCHEDULED_POOL_SIZE = 5;

    @Bean("workerExecutor")
    public ScheduledExecutorService workerExecutor() {
        CustomizableThreadFactory tFactory = new CustomizableThreadFactory("WORKER-THREAD-");
        tFactory.setThreadGroupName("QUEUE-WORKER-GROUP");
        tFactory.setThreadPriority(Thread.NORM_PRIORITY);

        return Executors.newSingleThreadScheduledExecutor(tFactory);
    }

    @Bean("workerExecutorMultithreaded")
    @Primary
    public ScheduledExecutorService workerExecutorMultithreaded() {
        CustomizableThreadFactory tFactory = new CustomizableThreadFactory("WORKER-MULTTHREAD-");
        tFactory.setThreadGroupName("QUEUE-WORKER-GROUP");
        tFactory.setThreadPriority(Thread.NORM_PRIORITY);

        return Executors.newScheduledThreadPool(SCHEDULED_POOL_SIZE, tFactory);
    }

}
