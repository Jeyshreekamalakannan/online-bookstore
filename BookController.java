
package com.bookstore.controller;

import com.bookstore.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String viewBooks(@RequestParam(required = false) String keyword, Model model) {
        model.addAttribute("books",
            keyword == null ? bookService.getAllBooks() : bookService.searchBooks(keyword));
        return "books";
    }
}
