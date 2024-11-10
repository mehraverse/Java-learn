import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;

public class saveToFile {
    public void saveBooksToFile(ArrayList<Book> bookList, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (Book book : bookList) {
                writer.write(book.getTitle() + "," + book.getAuthor() + "," + book.getisbn() + "\n");
            }
            System.out.println("Books saved to file");
        } catch (IOException e) {
            System.out.println("An error occured while saving books: " + e.getMessage());
        }
    }

    public List loadBooksFromFile(String filename) {
        List bookList = new List();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length == 3) {
                    Book book = new Book(details[0], details[1], details[2]);
                    bookList.addBook(book);
                }
            }
            System.out.println("Books loaded from file");
        } catch (IOException e) {
            System.out.println("An error occured while loading books: " + e.getMessage());
        }
        return bookList;
    }

    public void exportBooksToFile(ArrayList<Book> bookList, String filename) {
        // Export in one go
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename))) {
            for (Book book : bookList) {
                bufferedWriter.write(book.getTitle() + " - " + book.getAuthor() + " - " + book.getisbn());
                bufferedWriter.newLine();
            }
            System.out.println("Written Book to File");
        } catch (IOException e) {
            Logger.logAction("Error saving file: " + e.getMessage());
        }

    }

    public List importsBookFromFile(String filename) {
        List bookList = new List();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] details = line.split(" - ");
                if (details.length == 3) {
                    Book book = new Book(details[0], details[1], details[2]);
                    bookList.addBook(book);
                }
            }
        } catch (IOException e) {
            Logger.logAction("Error loading file: " + e.getMessage());
        }
        return bookList;
    }
}