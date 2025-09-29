package com.theberdakh.notes_app.model;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Table
public record Note(
        @Id
        Integer id,
        @NotBlank
        String title,
        String description,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
){}