package com.example.demo2;

import com.example.demo2.entities.Billboard;
import com.example.demo2.repositories.BillboardRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.util.Date;

@SpringBootApplication
public class Demo2Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo2Application.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(BillboardRepository br){
        return args -> {
            br.save(new Billboard(null,"test",new Date(),"Admin",new Date(),"test"));

            br.findAll().forEach(p->{
                System.out.println(p.getId());
            });
        };
    }

}
