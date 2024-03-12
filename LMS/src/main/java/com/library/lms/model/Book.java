package com.library.lms.model;

import jakarta.persistence.*;
import lombok.Data;


@Data

    @Entity
    public class Book {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String title;
        private String author;
        private String isbn;
    }

