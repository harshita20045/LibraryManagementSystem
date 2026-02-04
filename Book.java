public class Book extends LibraryItem {
  
    private String author;

    public Book(int id, String title, String author) {
        super(id, title); 
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    
    @Override
    public void displayDetails() {
        System.out.println("📖 Book ID: " + id + 
                         " | Title: " + title + 
                         " | Author: " + author + 
                         " | Status: " + (isAvailable ? "Available" : "Borrowed"));
    }

    @Override
    public String getItemType() {
        return "Book";
    }

  
    @Override
    public String toString() {
        return "Book ID: " + id + 
               " | Title: " + title + 
               " | Author: " + author + 
               " | Status: " + (isAvailable ? "Available" : "Borrowed");
    }
}