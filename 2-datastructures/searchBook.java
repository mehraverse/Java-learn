import java.util.ArrayList;

public class searchBook {
    public void search(String query, ArrayList<Book> bookList) {
        try {
            if (bookList.isEmpty()) {
                Logger.logAction("No books available in the library");
                return;
            }
            boolean found = false;
            for (Book book : bookList) {
                if (book.getTitle().equalsIgnoreCase(query) || book.getAuthor().equalsIgnoreCase(query)) {
                    Logger.logAction("Found: " + book.getTitle() + " by " + book.getAuthor());
                    found = true;
                    break;
                }
            }
            if (!found) {
                throw new BookNotFoundException("No book found with the title or author: " + query);
            }
        } catch (BookNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Error: Book list or book objects cannot be null");
        } catch (Exception e) {
            System.out.println("An unexpected error occured: " + e.getMessage());
        }
    }
}