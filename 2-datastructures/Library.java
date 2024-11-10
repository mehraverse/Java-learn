public class Library {
    public static void main(String[] args) {
        Book[] books = new Book[5];
        // intitalize the book with sample book data
        books[0] = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565");
        books[1] = new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084");
        books[2] = new Book("1984", "George Orwell", "9780451524935");
        books[3] = new Book("Moby Dick", "Herman Melville", "9781503280786");
        books[4] = new Book("Pride and Prejudice", "Jane Austen", "9781503290563");

        /*
         * for(Book book : books){
         * System.out.println(book.getAuthor());
         * }
         */

        List bookList = new List();
        bookList.addBook(books[0]);
        bookList.addBook(books[2]);
        bookList.addBook(books[3]);
        bookList.displayBooks();
        bookList.displayBooks();

        Authors authorSet = new Authors();
        for (Book book : books) {
            authorSet.addAuthor(book.getAuthor());
        }
        authorSet.displayAuthors();
        authorSet.removeAuthor("Jane Austen");
        authorSet.removeAuthor("Herman Melville");
        System.out.println("\nAuthors after removal:");
        authorSet.displayAuthors();
        System.out.println("\n");
        bookMap Map = new bookMap();
        Map.addBookToMap(books[0]);
        Map.addBookToMap(books[1]);
        Map.displayBooksInMap();
        System.out.println("\n");
        System.out.println(Map.getBookByIsbn("9780061120084").getTitle());
        System.out.println("\nSearching:");
        searchBook SB = new searchBook();
        SB.search("1984", bookList.getBooks());
        SB.search("1964", bookList.getBooks());
        // bookList.addBook(books[2]);
        // bookList.removeBook("1964");
        bookList.displayBooks();
        Sort.sortBooksBy(bookList.getBooks(), "AUThor");

        saveToFile SF = new saveToFile();
        SF.saveBooksToFile(bookList.getBooks(), "books.txt");

        SF.exportBooksToFile(bookList.getBooks(), "books2.txt");
        List newBookList = new List();
        newBookList = SF.importsBookFromFile("books2.txt");
        System.out.println("Reading from file: ");
        newBookList.displayBooks();
    }
}
