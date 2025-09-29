package com.theberdakh.notes_app.repository;

import com.theberdakh.notes_app.model.Note;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface NoteRepository extends ListCrudRepository<Note, Integer> {

    List<Note> findAllByTitleContains(String keyword);
}
