package com.bookstore.onlineBookStore.service;

import com.bookstore.onlineBookStore.entity.Book;
import com.bookstore.onlineBookStore.repository.BookStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class BookStoreServiceImpl implements BookStoreService{

    @Autowired
    private final BookStoreRepository bookStoreRepository;


    public BookStoreServiceImpl(BookStoreRepository bookStoreRepository) {
        this.bookStoreRepository = bookStoreRepository;
    }

    public List<Book> getAllBooks() {
        return bookStoreRepository.findAll();
    }

    public Book getBookById(Integer id) {
        return bookStoreRepository.findById(id).orElse(null);
    }

    public Book addBook(Book book) {
       return bookStoreRepository.save(book);
    }

    public Book updateBookById(Integer id, Book book) {
        if(getBookById(id) != null) {
            book.setId(id);
            return bookStoreRepository.save(book);
        } else {
            return null;
        }
    }

    public boolean deleteBookById(Integer id) {
        if(getBookById(id) != null) {
            bookStoreRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

