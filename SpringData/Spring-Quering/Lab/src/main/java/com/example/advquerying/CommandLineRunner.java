package com.example.advquerying;

import com.example.advquerying.entities.Size;
import com.example.advquerying.services.ShampooServices;

public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {

    private final ShampooServices shampooServices;

    public CommandLineRunner(ShampooServices shampooServices) {
        this.shampooServices = shampooServices;
    }

    @Override
    public void run(String... args) throws Exception {
        //ex1
        shampooServices.findAllBySizeOrderById(Size.valueOf("MEDIUM"))
        .forEach(System.out::println);
    }
}
