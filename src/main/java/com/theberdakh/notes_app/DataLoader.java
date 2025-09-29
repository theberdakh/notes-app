package com.theberdakh.notes_app;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.theberdakh.notes_app.model.Note;
import com.theberdakh.notes_app.repository.NoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    private final NoteRepository noteRepository;
    private final ObjectMapper objectMapper;

    public DataLoader(NoteRepository noteRepository, ObjectMapper objectMapper) {
        this.noteRepository = noteRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("DataLoader 👋");
        try(InputStream inputStream = TypeReference.class.getResourceAsStream("/data/notes.json")) {
            noteRepository.saveAll(objectMapper.readValue(inputStream, new TypeReference<List<Note>>(){}));
        }
    }
}
