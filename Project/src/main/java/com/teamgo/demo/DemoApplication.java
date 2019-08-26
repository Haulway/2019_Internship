package com.teamgo.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication
@ComponentScan(basePackages = {"com.teamgo.demo.controller","com.teamgo.demo.service","com.teamgo.demo.config"})
@MapperScan(basePackages = "com.teamgo.demo.mapper")
public class DemoApplication extends SpringBootServletInitializer implements WebApplicationInitializer {
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){

        return application.sources(DemoApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
