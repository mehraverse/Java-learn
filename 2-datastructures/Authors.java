
//Hashset
import java.util.HashSet;

public class Authors {

    private HashSet<String> AuthorSet;

    public Authors() {
        AuthorSet = new HashSet<>();
    }

    public void addAuthor(String authorName) {
        AuthorSet.add(authorName);
    }

    public void removeAuthor(String authorName) {
        AuthorSet.remove(authorName);
    }

    public void displayAuthors() {
        for (String author : AuthorSet) {
            System.out.println("Author Name: " + author);
        }
    }
}