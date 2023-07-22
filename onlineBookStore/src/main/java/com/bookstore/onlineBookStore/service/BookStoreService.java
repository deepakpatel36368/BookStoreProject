package com.bookstore.onlineBookStore.service;

import com.bookstore.onlineBookStore.entity.Book;
import com.bookstore.onlineBookStore.repository.BookStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class BookStoreService {

    @Autowired
    private final BookStoreRepository bookStoreRepository;


    public BookStoreService(BookStoreRepository bookStoreRepository) {
        this.bookStoreRepository = bookStoreRepository;
    }

    public List<Book> getBookList(Integer x) {

        List<Book> listOfBooks = new ArrayList<>();

        Book book = new Book();
        book.setAuthor("Amis");
        book.setTitle("Shiva");
        book.setId(99999L);
        book.setIsbn("Yes");

        listOfBooks.add(book);

        return listOfBooks;
    }

    public List<Book> getAllBooks() {
        return bookStoreRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookStoreRepository.findById(id).orElse(null);
    }

    public Book addBook(Book book) {
       return bookStoreRepository.save(book);
    }

    public Book updateBookById(Long id, Book book) {
        if(getBookById(id) != null) {
            book.setId(id);
            return bookStoreRepository.save(book);
        } else {
            return null;
        }
    }

    public boolean deleteBookById(Long id) {
        if(getBookById(id) != null) {
            bookStoreRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

