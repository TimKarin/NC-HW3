package ru.karin.nc.hw3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import ru.karin.nc.hw3.component.EmailService;

@SpringBootApplication
@ServletComponentScan
public class SpringBootStarter {


    public static void main(String[] args) {
        SpringApplication.run(SpringBootStarter.class);
    }
}
