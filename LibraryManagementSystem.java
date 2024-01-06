package LibraryManagementJava;
import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author;
    }
}

class Library {
    ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void displayBooks() {
        System.out.println("Library Books:");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System Menu:");
            System.out.println("1. Add a Book");
            System.out.println("2. Remove a Book");
            System.out.println("3. Display All Books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter the author: ");
                    String author = scanner.nextLine();
                    Book newBook = new Book(title, author);
                    library.addBook(newBook);
                    System.out.println("Book added successfully.");
                    break;
                case 2:
                    System.out.print("Enter the title of the book to remove: ");
                    String bookTitleToRemove = scanner.nextLine();
                    Book bookToRemove = null;
                    for (Book book : library.books) {  // Corrected 'library.book' to 'library.books'
                        if (book.getTitle().equalsIgnoreCase(bookTitleToRemove)) {
                            bookToRemove = book;
                            break;
                        }
                    }
                    if (bookToRemove != null) {
                        library.removeBook(bookToRemove);
                        System.out.println("Book removed successfully.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 3:
                    library.displayBooks();
                    break;
                case 4:
                    System.out.println("Exiting Library Management System.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
