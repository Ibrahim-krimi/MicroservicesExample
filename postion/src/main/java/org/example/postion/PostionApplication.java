package org.example.postion;

import org.example.postion.entites.Postion;
import org.example.postion.repositories.PostionRepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class PostionApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostionApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(PostionRepositories postionRepositories){
        return args -> {
            Postion position1 = new Postion(1L, "Développeur Java", 50000.0, null, List.of(1L, 2L)); // Supposons que les compétences avec ID 1 et 2 existent déjà
            Postion position2 = new Postion(2L, "Architecte logiciel", 70000.0, null, List.of(2L, 3L)); // Supposons que les compétences avec ID 2 et 3 existent déjà

            postionRepositories.save(position1);
            postionRepositories.save(position2);
        };
    }
}
