package com.ccl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
//@ComponentScan("com.ccl.managerapi")
public class Entranceapi extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(Entranceapi.class);
    }


    public static void main(String[] args) {
        SpringApplication.run(Entranceapi.class, args);
    }

}
