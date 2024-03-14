package com.library.lms.services;

import com.library.lms.model.Borrowing;

public interface BorrowingService {

    Borrowing borrowBook(Long bookId, Long memberId);

    Borrowing returnBook(Long borrowingId);
}
