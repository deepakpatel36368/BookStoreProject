package com.bookstore.onlineBookStore.service;

import com.bookstore.onlineBookStore.entity.Book;

import java.util.List;

public interface BookStoreService {

    List<Book> getAllBooks();

    Book getBookById(Integer id);

    Book addBook(Book book);

    Book updateBookById(Integer id, Book book);

    boolean deleteBookById(Integer id);
}
