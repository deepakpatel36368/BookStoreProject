package com.bookstore.onlineBookStore.controller;

import com.bookstore.onlineBookStore.entity.Book;
import com.bookstore.onlineBookStore.service.BookStoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookStoreController {

    @Autowired
    BookStoreServiceImpl bookStoreServiceImpl;

    @GetMapping("/index")
    public String homePage(Model model) {

        return "index";
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Book> books = bookStoreServiceImpl.getAllBooks();
        model.addAttribute("books", books);
        return "home";
    }

    /**
     * Get List of all book in the database.
     **/
    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return bookStoreServiceImpl.getAllBooks();
    }

    /**
     * Get book by Id.
     **/
    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Integer id) {
        Book book = bookStoreServiceImpl.getBookById(id);
        if(book == null) {
            return new ResponseEntity<>("Book with Book-Id " + id + " not found.", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(book, HttpStatus.OK);
        }
    }

    /**
     * Add book into the database.
     **/
    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody Book book) {
         bookStoreServiceImpl.addBook(book);
         return new ResponseEntity<>(book, HttpStatus.OK);
    }

    /**
     * Edit the book by id.
     **/
    @PutMapping("/{id}")
    public ResponseEntity<?> updteBookbyId(@PathVariable Integer id, @RequestBody Book book) {
        Book book1 = bookStoreServiceImpl.updateBookById(id, book);
        if (book == null) {
            return new ResponseEntity<>("Book with Id " + id + " does not exist.", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(book1, HttpStatus.OK);
        }
    }
}
