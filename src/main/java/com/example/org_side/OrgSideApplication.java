package com.example.org_side;

import com.example.org_side.Entities.Categories;
import com.example.org_side.Entities.Product;
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
            productRepository.deleteAll();
            Categories c1 = categoryRepository.findById("C1").get();

            Stream.of("P1","P2","P3").forEach(p->{
              Product p1=  productRepository.save(new Product(null,p,Math.random()*1000,c1));
              //pour mettre relation en deu sence
              c1.getProducts().add(p1);
              categoryRepository.save(c1);
             // productRepository.findAll().forEach(System.out::println); boucle infini car j'ai fait un lien entre product et category
            });

        };
    }
}
