package com.library.lms.Controller;

import com.library.lms.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/")
    public String listBooks(Model model){
        model.addAttribute("books",bookRepository.findAll());
        return "books";

    }
}
