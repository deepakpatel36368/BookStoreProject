package com.bookstore.onlineBookStore.repository;

import com.bookstore.onlineBookStore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface BookStoreRepository extends JpaRepository<Book, Long> {
}
