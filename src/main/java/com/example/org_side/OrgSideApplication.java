package com.example.org_side;

import com.example.org_side.Entities.Categories;
import com.example.org_side.dao.CategoryRepository;
import com.example.org_side.dao.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.stream.Stream;

@SpringBootApplication
public class OrgSideApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrgSideApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CategoryRepository categoryRepository, ProductRepository productRepository) {
        return args -> {
            categoryRepository.deleteAll();
            Stream.of("C1 Ordinateur", "C2 imprimante").forEach(c -> {
                categoryRepository.save(new Categories(c.split(" ")[0], c.split(" ")[1], new ArrayList<>()));
            });
            categoryRepository.findAll().forEach(System.out::println);
        };
    }
}
