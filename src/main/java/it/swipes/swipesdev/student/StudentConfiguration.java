package it.swipes.swipesdev.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student alex = new Student(
                    "alex",
                    "alex@gmail.com",
                    LocalDate.of(2004, Month.JANUARY, 7)
            );

            Student mariam = new Student(
                    "Mariam",
                    "mariam.jamal@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );


            repository.saveAll(List.of(alex, mariam));
        };
    }
}
