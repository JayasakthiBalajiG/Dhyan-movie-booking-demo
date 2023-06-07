package com.dhyanmoviebooking;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication()
@RestController
@EnableJpaRepositories(basePackages = "com.dhyanmoviebooking")
@EntityScan(basePackages = "com.dhyanmoviebooking.model")

public class DhyanMovieBooking {
    public static void main(String[] args) {
        SpringApplication.run(DhyanMovieBooking.class,args);
        System.out.println("Heloo world");
    }

    @GetMapping("/user")
    public UserResposne aboutUser(){
        return new UserResposne(
                "User name",
                List.of("Search", "Book tickets")
                );
    }

    record UserResposne(
            String name,
            List<String> actions
    ){}

    @GetMapping("/operator")
    public OperatorResponse operatorResponse(){
        return new OperatorResponse(
                "Operator name",
                List.of("Add movie")
                );
    }

    record OperatorResponse (
            String name,
            List<String> actions
    ){}
}
