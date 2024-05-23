package com.example.knowledgekite.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private SectionType name;
}

enum SectionType {
    VIDEO,
    TEXT,
    QUIZ
}