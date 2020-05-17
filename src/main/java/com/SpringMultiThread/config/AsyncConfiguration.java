package com.SpringMultiThread.config;

import java.util.concurrent.Executor;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


@Configuration
@EnableAsync
public class AsyncConfiguration {
	private Logger logger = Logger.getLogger(AsyncConfiguration.class);
    
	
    @Bean (name = "taskExecutor")
    public Executor taskExecutor() {
    	logger.info("Creating Async Task Executor");
        final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(5);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("SpringMultiThread-");
        executor.initialize();
        return executor;
    }
}
