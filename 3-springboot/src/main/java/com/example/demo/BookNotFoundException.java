package com.example.demo;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(int id) {
        super("404: Book not found with id: " + id);
    }
}
