package org.example.springmvcproductmanagement;

import org.example.springmvcproductmanagement.entites.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.example.springmvcproductmanagement.repository.ProductRepository;

//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@SpringBootApplication()
public class SpringMvcProductManagementApplication {

	public static void main(String[] args) {

        SpringApplication.run(SpringMvcProductManagementApplication.class, args);
        System.out.println("Product Management Application has been started");

	}
    @Bean
    CommandLineRunner start(ProductRepository productRepository) {
        return args -> {

            productRepository.save(Product.builder()
                    .name("pc1")
                    .quantity(10)
                    .price(100000)
                    .build());

            productRepository.save(Product.builder()
                    .name("pc2")
                    .quantity(40)
                    .price(170000)
                    .build());

            productRepository.save(Product.builder()
                    .name("pc3")
                    .quantity(30)
                    .price(30000)
                    .build());

            productRepository.findAll().forEach(p -> System.out.println(p.getName()));
        };
    }


}
