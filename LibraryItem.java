
public abstract class LibraryItem {
    
    protected int id;
    protected String title;
    protected boolean isAvailable;

    public LibraryItem(int id, String title) {
        this.id = id;
        this.title = title;
        this.isAvailable = true;
    }

    
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }


    public abstract void displayDetails();
    public abstract String getItemType();

    public void markAsBorrowed() {
        this.isAvailable = false;
    }

    public void markAsReturned() {
        this.isAvailable = true;
    }
}