package com.theberdakh.notes_app.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "note")
public record NoteProperties(
        String welcomeMessage,
        String about
) {
}
