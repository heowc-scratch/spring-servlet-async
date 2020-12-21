package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.MissingRequiredPropertiesException;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.concurrent.Callable;

@SpringBootApplication
public class SpringServletAsyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringServletAsyncApplication.class, args);
    }

}

@Configuration
class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        final ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setThreadNamePrefix("app-exec");
        taskExecutor.initialize();
        configurer.setTaskExecutor(taskExecutor);
    }
}

@RestController
class SimpleController {

    private final Logger logger = LoggerFactory.getLogger(SimpleController.class);

    @GetMapping("/sync")
    public String sync() {
        logger.info("{}", "sync");
        return "sync";
    }

    @GetMapping("/async")
    public Callable<String> async() {
        return () -> {
            logger.info("{}", "async");
            return "async";
        };
    }
}