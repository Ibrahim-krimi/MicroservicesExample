package org.example.skill;

import org.example.skill.entites.Skill;
import org.example.skill.repositories.SkillRepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SkillApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkillApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(SkillRepositories skillRepositories){
        return args -> {
            Skill skill1 = new Skill(null, "Java");
            Skill skill2 = new Skill(null, "Spring Boot");

            skillRepositories.save(skill1);
            skillRepositories.save(skill2);
        };

    }
}
