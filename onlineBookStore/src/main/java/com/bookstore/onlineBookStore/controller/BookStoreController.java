package com.bookstore.onlineBookStore.controller;

import com.bookstore.onlineBookStore.entity.Book;
import com.bookstore.onlineBookStore.service.BookStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookStoreService.getBookById(id);
        if(book == null) {
            return new ResponseEntity<>(book, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(book, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
         bookStoreService.addBook(book);
         return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updteBookbyId(@PathVariable Long id, @RequestBody Book book) {
        Book book1 = bookStoreService.updateBookById(id, book);
        return  null;
    }
}
