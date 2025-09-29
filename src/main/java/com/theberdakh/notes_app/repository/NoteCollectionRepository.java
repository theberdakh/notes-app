package com.theberdakh.notes_app.repository;

import com.theberdakh.notes_app.model.Note;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class NoteCollectionRepository {
    private final List<Note> notes = new ArrayList<>();

    public NoteCollectionRepository() {}

    public List<Note> findAll() {
        return notes;
    }

    public Optional<Note> findById(Integer id){
        return notes.stream().filter(note -> note.id().equals(id)).findFirst();
    }
    public void save(Note note) {
        notes.removeIf(c -> c.id().equals(note.id()));
        notes.add(note);
    }

    @PostConstruct
    private void init() {
        Note note = new Note(
                1,
                "Title",
                "Description of Title",
                LocalDateTime.now(),
                null
        );
        notes.add(note);
    }

    public boolean existById(Integer id) {
        return notes.stream().filter(note -> note.id().equals(id)).count() == 1;
    }

    public void delete(Integer id){
        notes.removeIf(c -> c.id().equals(id));
    }
}
