
///HashMap
import java.util.HashMap;

public class bookMap {
    private HashMap<String, Book> bookMap;

    public bookMap() {
        bookMap = new HashMap<>();
    }

    public void addBookToMap(Book book) {
        bookMap.put(book.getisbn(), book);
    }

    public Book getBookByIsbn(String isbn) {
        return bookMap.get(isbn);
    }

    public void displayBooksInMap() {
        for (Book book : bookMap.values()) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor());
        }
    }
}