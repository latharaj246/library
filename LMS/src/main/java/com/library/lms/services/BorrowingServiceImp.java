package com.library.lms.services;

import com.library.lms.model.Borrowing;
import com.library.lms.repo.BookRepository;
import com.library.lms.repo.BorrowingRepository;
import com.library.lms.repo.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class BorrowingServiceImp implements BorrowingService{

    @Autowired
    BookRepository bookRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    BorrowingRepository borrowingRepository;
    @Override
    public Borrowing borrowBook(Long bookId, Long memberId) {
        Borrowing borrowing = new Borrowing();
        borrowing.setBook(bookRepository.findById(bookId).get());
        borrowing.setBorrowedDate(new Date());
        return borrowingRepository.save(borrowing);
    }

    @Override
    public Borrowing returnBook(Long borrowingId) {
      Borrowing borrowing =  borrowingRepository.findById(borrowingId).get();
      borrowing.setReturnDate(new Date());
        return borrowingRepository.save(borrowing);
    }
}
