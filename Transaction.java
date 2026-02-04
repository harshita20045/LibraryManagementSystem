import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Transaction class demonstrates ENCAPSULATION
 */
public class Transaction {
    private int transactionId;
    private int memberId;
    private int itemId;
    private String itemType; // "Book" or "Magazine"
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private double fine;

    // Constructor
    public Transaction(int transactionId, int memberId, int itemId, String itemType) {
        this.transactionId = transactionId;
        this.memberId = memberId;
        this.itemId = itemId;
        this.itemType = itemType;
        this.borrowDate = LocalDate.now();
        this.returnDate = null;
        this.fine = 0.0;
    }

    // Getters and Setters - ENCAPSULATION
    public int getTransactionId() {
        return transactionId;
    }

    public int getMemberId() {
        return memberId;
    }

    public int getItemId() {
        return itemId;
    }

    public String getItemType() {
        return itemType;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public double getFine() {
        return fine;
    }

    // Calculate fine based on days overdue
    public double calculateFine() {
        if (returnDate == null) {
            returnDate = LocalDate.now();
        }

        long daysBorrowed = ChronoUnit.DAYS.between(borrowDate, returnDate);

        // Fine: ₹10 per day after 7 days
        if (daysBorrowed > 7) {
            fine = (daysBorrowed - 7) * 10.0;
        } else {
            fine = 0.0;
        }

        return fine;
    }

    @Override
    public String toString() {
        return "Transaction ID: " + transactionId +
               " | Member ID: " + memberId +
               " | Item ID: " + itemId +
               " | Type: " + itemType +
               " | Borrow Date: " + borrowDate +
               " | Return Date: " + (returnDate != null ? returnDate : "Not Returned") +
               " | Fine: ₹" + fine;
    }
}