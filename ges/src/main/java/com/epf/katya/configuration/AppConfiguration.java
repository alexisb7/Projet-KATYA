package com.epf.katya.configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.epf.katya.dao", "com.epf.katya.service", "com.epf.katya.persistence"})

public class AppConfiguration {
    
}
