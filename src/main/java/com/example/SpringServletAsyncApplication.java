package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

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

    @GetMapping("/callable")
    public Callable<String> callable() {
        return () -> {
            logger.info("{}", "callable");
            return "callable";
        };
    }

    @GetMapping("/deferredResult")
    public DeferredResult<String> deferredResult() {
        logger.info("{}", "deferredResult");
        final DeferredResult<String> result = new DeferredResult<>();
        result.setResult("deferredResult");
        return result;
    }

    @GetMapping("/completableFuture")
    public CompletableFuture<String> completableFuture() {
        logger.info("{}", "completableFuture");
        return CompletableFuture.completedFuture("completableFuture");
    }
}
