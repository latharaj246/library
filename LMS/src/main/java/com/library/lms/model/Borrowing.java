package com.library.lms.model;

import jakarta.persistence.*;
import lombok.Data;


import java.util.Date;

@Data
@Entity
public class Borrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="book_id", referencedColumnName = "id")
    private Book book;
    @ManyToOne
    @JoinColumn(name="member_id", referencedColumnName = "id")
    private Member member;
    private Date borrowedDate;
    private Date returnDate;

}
