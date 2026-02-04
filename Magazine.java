
public class Magazine extends LibraryItem {
    private String publisher;
    private int issueNumber;

   
    public Magazine(int id, String title, String publisher, int issueNumber) {
        super(id, title); 
        this.publisher = publisher;
        this.issueNumber = issueNumber;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    
    @Override
    public void displayDetails() {
        System.out.println("📰 Magazine ID: " + id + 
                         " | Title: " + title + 
                         " | Publisher: " + publisher + 
                         " | Issue: #" + issueNumber +
                         " | Status: " + (isAvailable ? "Available" : "Borrowed"));
    }
   
    @Override
    public String getItemType() {
        return "Magazine";
    }

  
    @Override
    public String toString() {
        return "Magazine ID: " + id + 
               " | Title: " + title + 
               " | Publisher: " + publisher + 
               " | Issue: #" + issueNumber +
               " | Status: " + (isAvailable ? "Available" : "Borrowed");
    }
}