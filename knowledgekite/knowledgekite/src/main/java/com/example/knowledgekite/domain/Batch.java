package com.example.knowledgekite.domain;


import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.util.Date;

@Data
@Entity
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant startDate;
    private Instant endDate;

    @ManyToOne
    Course course;
}
