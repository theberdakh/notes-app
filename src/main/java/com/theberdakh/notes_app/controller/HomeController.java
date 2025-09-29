package com.theberdakh.notes_app.controller;

import com.theberdakh.notes_app.config.NoteProperties;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Value("${note.welcomeMessage: Default Welcome}")
    private String welcomeMessage;

    private final NoteProperties properties;

    public HomeController(NoteProperties properties) {
        this.properties = properties;
    }

    @GetMapping("/")
    public NoteProperties home(){
        return properties;
    }
}
