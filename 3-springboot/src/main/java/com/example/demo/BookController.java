package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    // In-memory storage of books
    private List<Book> bookList = new ArrayList<>();
    @Autowired
    private BookRepository bookRepository;

    public BookController() {
        bookList.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1));
        bookList.add(new Book("To Kill a Mockingbird", "Harper Lee", 2));
        bookList.add(new Book("1984", "George Orwell", 3));
    }

    // Endpoint to get all books
    @GetMapping({ "/books", "/books/" })
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public Book getBookByIsbn(@PathVariable int id) {
        for (Book book : bookList) {
            if (book.getid() == id) {
                return book;
            }
        }
        throw new BookNotFoundException(id);
    }

    @PostMapping("/books")
    public Book createBook(@Valid @RequestBody Book newBook) {
        return bookRepository.save(newBook); // Save book to database
    }

    /*
     * @PutMapping("/books/{id}")
     * public Book updateBook(@PathVariable int id, @RequestBody @Valid Book
     * updatedBook) {
     * for (Book book : bookList) {
     * if (id == book.getid()) {
     * book.setTitle(updatedBook.getTitle());
     * book.setAuthor(updatedBook.getAuthor());
     * book.setid(updatedBook.getid());
     * return book;
     * }
     * }
     * throw new BookNotFoundException(id);
     * }
     */

    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody @Valid Book updatedBook) {
        Book existingBook = bookRepository.findById(id).orElse(null);

        if (existingBook == null) {
            throw new BookNotFoundException(id);
        }

        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());

        bookRepository.save(existingBook);
        return existingBook;
    }
}
