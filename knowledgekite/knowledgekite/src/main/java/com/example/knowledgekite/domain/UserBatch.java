package com.example.knowledgekite.domain;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class UserBatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "batch_id")
    Batch batch;

}
