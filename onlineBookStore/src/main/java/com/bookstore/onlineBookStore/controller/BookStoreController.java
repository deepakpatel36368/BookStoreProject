package com.bookstore.onlineBookStore.controller;

import com.bookstore.onlineBookStore.entity.Book;
import com.bookstore.onlineBookStore.service.BookStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/books")
public class BookStoreController {

    @Autowired
    private BookStoreService bookStoreService;

    @GetMapping("/all")
    public String getAllBooks() {
        return "all books are here.";
    }

    @GetMapping("/listBook")
    public List<Book> getListOfBooks() {
      return bookStoreService.getBookList(5);
    }
}
