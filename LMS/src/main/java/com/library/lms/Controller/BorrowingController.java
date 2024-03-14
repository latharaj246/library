package com.library.lms.Controller;

import com.library.lms.model.Borrowing;
import com.library.lms.repo.BookRepository;
import com.library.lms.repo.BorrowingRepository;
import com.library.lms.repo.MemberRepository;
import com.library.lms.services.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class BorrowingController {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    BorrowingService borrowingService;

    @Autowired
    BorrowingRepository borrowingRepository;

    @GetMapping("/borrow")
    public String showBorrowForm(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        model.addAttribute("members", memberRepository.findAll());
        return "borrow_book";
    }

    @PostMapping("/borrow")
    public String borrowBook(@RequestParam Long memberId, @RequestParam Long bookId, Model model) {
        borrowingService.borrowBook(bookId, memberId);
        model.addAttribute("message", "Book Borrowed Successfully!");
        return "borrow_success";

    }

    @GetMapping("/return")
    public String showReturnForm(Model model) {
        model.addAttribute("borrowers", borrowingRepository.findByReturnDate(null));
        return "return_book";
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam Long borrwingId, Model model) {
        borrowingService.returnBook(borrwingId);
        model.addAttribute("message", "Book Returned Successfully!");
        return "return_success";
    }
}
