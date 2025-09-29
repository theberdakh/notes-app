package com.theberdakh.notes_app.controller;

import com.theberdakh.notes_app.model.Note;
import com.theberdakh.notes_app.repository.NoteRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/notes")
@CrossOrigin
public class NoteController {

    private NoteRepository noteRepository;

    public NoteController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @GetMapping("")
    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Note findById(@PathVariable Integer id) {
        return noteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Note note) {
        noteRepository.save(note);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Note note, @PathVariable Integer id) {
        if (!noteRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content is not found 1");
        }
        noteRepository.save(note);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        noteRepository.deleteById(id);
    }

    @GetMapping("/filter/{keyword}")
    public List<Note> findByTitle(@PathVariable String keyword) {
        return noteRepository.findAllByTitleContains(keyword);
    }
}
