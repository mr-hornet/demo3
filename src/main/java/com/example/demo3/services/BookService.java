package com.example.demo3.services;

import com.example.demo3.model.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

@Service
public class BookService {

    private final HashMap<Long, Book> books = new HashMap<>();
    private long lastId = 0;

    public Book createBook(Book book) {
        book.setId(++lastId);
        return books.put(lastId, book);
    }

    public Book findBook(long id) {
        return books.get(id);
    }

    public Book editBook(Book book) {
        if (books.containsKey(book.getId())) {
            return books.put(book.getId(), book);
        }
        return null;
    }

    public Book deleteBook(long id) {
        return books.remove(id);
    }

    public Collection<Book> getAllBooks() {
        return books.values();
    }
}
