import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sort {
    private static Comparator<Book> titleComparator = (b1, b2) -> b1.getTitle().compareTo(b2.getTitle());
    private static Comparator<Book> authorComparator = (b1, b2) -> b1.getAuthor().compareTo(b2.getAuthor());
    private static Comparator<Book> isbnComparator = (b1, b2) -> b1.getisbn().compareTo(b2.getisbn());

    public static void sortBooksBy(ArrayList<Book> bookList, String criteria) {
        switch (criteria.toLowerCase()) {
            case "title":
                Collections.sort(bookList, titleComparator);
                break;
            case "author":
                Collections.sort(bookList, authorComparator);
                break;
            case "isbn":
                Collections.sort(bookList, isbnComparator);
                break;
            default:
                System.out.println("unknown criteria");
                return;
        }

        for (Book book : bookList) {
            System.out.println(book.getTitle() + " by " + book.getAuthor() + " - ISBN: " + book.getisbn());
        }
    }
}
