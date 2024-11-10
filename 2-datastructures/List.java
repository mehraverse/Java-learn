
//arraylist
import java.util.ArrayList;

public class List {
    private ArrayList<Book> bookList;

    public List() {
        bookList = new ArrayList<>();
    }

    public void addBook(Book book) {
        for (Book existingBook : bookList) {
            if (existingBook.getisbn().equals(book.getisbn())) {
                throw new IllegalArgumentException("Book with ISBN: " + book.getisbn() + " already exists.");
            }
        }
        bookList.add(book);
        Logger.logAction("Added book: " + book.getTitle());
    }

    public void removeBook(String title) {
        boolean removed = bookList.removeIf(book -> book.getTitle().equals(title));
        Logger.logAction("Removed book: " + title);

        if (!removed) {
            throw new IllegalArgumentException("Book with title " + title + " not found.");
        }
    }

    public void displayBooks() {
        for (Book book : bookList) {
            System.out.println(book.getTitle());
        }
    }

    // Method to get the internal list of books
    public ArrayList<Book> getBooks() {
        return bookList; // Return the internal ArrayList
    }
}