package com.theberdakh.notes_app;

import com.theberdakh.notes_app.config.NoteProperties;
import com.theberdakh.notes_app.model.Note;
import com.theberdakh.notes_app.repository.NoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Arrays;

@EnableConfigurationProperties(NoteProperties.class)
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
       SpringApplication.run(Application.class, args);
    }

    /*@Bean
    CommandLineRunner commandLineRunner(NoteRepository repository) {
        return args -> {
            Note note = new Note(
                    null,
                    "Command Line Runner",
                    "Description of Title",
                    LocalDateTime.now(),
                    null
            );
            repository.save(note);
        };
    }*/

}
