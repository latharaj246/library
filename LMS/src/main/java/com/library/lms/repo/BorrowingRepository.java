package com.library.lms.repo;


import com.library.lms.model.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {

    List<Borrowing> findByReturnDate(Date date);
}
