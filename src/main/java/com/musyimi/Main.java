package com.musyimi;

import com.musyimi.repair.Repair;
import com.musyimi.repair.RepairRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner runner(RepairRepository repairRepository) {

        return args -> {
            Repair phone = new Repair(
                    "Mucomba",
                    "Nokia 3310",
                    "Nokia",
                    "The phone is not charging",
                    0722000000
            );
            Repair laptop = new Repair(
                    "Ruger",
                    "Lenovo 500",
                    "Lenovo",
                    "The Screen is broken",
                    0722111111
            );

            List<Repair> repairs = List.of(phone, laptop);
           // repairRepository.saveAll(repairs);

        };
    }
}
