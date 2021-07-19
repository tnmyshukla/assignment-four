package com.Assignment.AssignmentFour.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import java.util.concurrent.Executor;


/**
 * The type Async config.
 */
@Configuration
@EnableAsync
/**
 * Configuration class
 */
public class AsyncConfig {
  /**
   * Task executor executor.
   *
   * @return the executor
   */
  @Bean(name = "taskExecutor")
  /**
   * Task executor
   */
  public Executor taskExecutor() {
    final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(20);
    executor.setMaxPoolSize(20);
    executor.setQueueCapacity(2100);
    executor.setThreadNamePrefix("thread-");
    executor.initialize();
    return executor;
  }
}
