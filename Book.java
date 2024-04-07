import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Book {
    private String title;
    private String author;
    private double price;
    private int quantity;

    public Book(String title, String author, double price, int quantity) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Price: $" + price + ", Quantity: " + quantity;
    }
}

 class BookInventorySystem {
    private Map<String, Book> inventory;

    public BookInventorySystem() {
        inventory = new HashMap<>();
    }

    public void addBook(Book book) {
        inventory.put(book.getTitle(), book);
    }

    public void removeBook(String title) {
        inventory.remove(title);
    }

    public void updateBook(String title, int quantity) {
        Book book = inventory.get(title);
        if (book != null) {
            book.setQuantity(quantity);
            inventory.put(title, book);
        } else {
            System.out.println("Book not found.");
        }
    }

    public List<Book> searchByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : inventory.values()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> searchByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : inventory.values()) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        BookInventorySystem system = new BookInventorySystem();

        // Example usage
        Book book1 = new Book("OOP", "Dr.Tamim", 29.99, 10);
        Book book2 = new Book("CP", "Dr.Waleed", 24.99, 15);

        system.addBook(book1);
        system.addBook(book2);

        // Search by title
        String searchTitle = "OOP";
        List<Book> titleSearchResults = system.searchByTitle(searchTitle);
        if (titleSearchResults.isEmpty()) {
            System.out.println("No books found with the title: " + searchTitle);
        } else {
            System.out.println("Books found with the title '" + searchTitle + "':");
            for (Book book : titleSearchResults) {
                System.out.println(book);
            }
        }

        // Search by author
        String searchAuthor = "Dr.Waleed";
        List<Book> authorSearchResults = system.searchByAuthor(searchAuthor);
        if (authorSearchResults.isEmpty()) {
            System.out.println("No books found by author: " + searchAuthor);
        } else {
            System.out.println("Books found by author '" + searchAuthor + "':");
            for (Book book : authorSearchResults) {
                System.out.println(book);
            }
        }
    }
    
    
}
