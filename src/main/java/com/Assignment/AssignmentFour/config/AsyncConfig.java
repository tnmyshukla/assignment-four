package com.Assignment.AssignmentFour.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
@Configuration
@EnableAsync
/**
 * Configuration class
 */
public class AsyncConfig {
  @Bean(name="taskExecutor")
  /**
   * Task executor
   */
  public Executor taskExecutor(){
    final ThreadPoolTaskExecutor executor=new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(20);
    executor.setMaxPoolSize(25);
    executor.setQueueCapacity(100);
    executor.setThreadNamePrefix("thread-");
    executor.initialize();
    return executor;
  }
}