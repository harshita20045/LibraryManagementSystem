import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books;
    private List<Member> members;
    private List<Transaction> transactions;
    private int transactionCounter;

  
    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
        this.transactions = new ArrayList<>();
        this.transactionCounter = 1;
    }

  
    public void addBook(int id, String title, String author) {
       
        for (Book book : books) {
            if (book.getId() == id) {
                System.out.println("❌ Book with ID " + id + " already exists!");
                return;
            }
        }

        Book book = new Book(id, title, author);
        books.add(book);
        System.out.println("✅ Book added successfully!");
    }

    
    public void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("📚 No books available in the library.");
            return;
        }

        System.out.println("\n📚 ========== ALL BOOKS ==========");
        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println("==================================\n");
    }

   
    public void registerMember(int id, String name) {
     
        for (Member member : members) {
            if (member.getId() == id) {
                System.out.println("❌ Member with ID " + id + " already exists!");
                return;
            }
        }

        Member member = new Member(id, name);
        members.add(member);
        System.out.println("✅ Member registered successfully!");
    }

   
    public void viewAllMembers() {
        if (members.isEmpty()) {
            System.out.println("👥 No members registered.");
            return;
        }

        System.out.println("\n👥 ========== ALL MEMBERS ==========");
        for (Member member : members) {
            System.out.println(member);
        }
        System.out.println("====================================\n");
    }

  
    public void borrowBook(int memberId, int bookId) {
       
        Member member = findMemberById(memberId);
        if (member == null) {
            System.out.println(" Member not found!");
            return;
        }

       
        if (!member.canBorrowBook()) {
            System.out.println(" Member has already borrowed 3 books. Cannot borrow more!");
            return;
        }
   Book book = findBookById(bookId);
        if (book == null) {
            System.out.println(" Book not found!");
            return;
        }

      
        if (!book.isAvailable()) {
            System.out.println(" Book is already borrowed!");
            return;
        }

   
        Transaction transaction = new Transaction(transactionCounter++, memberId, bookId);
        transactions.add(transaction);

        
        book.markAsBorrowed();
        member.borrowBook(bookId);

        System.out.println("✅ Book borrowed successfully!");
        System.out.println("📅 Borrow Date: " + transaction.getBorrowDate());
        System.out.println("⚠️  Please return within 7 days to avoid fine (₹10/day after 7 days)");
    }


    public void returnBook(int memberId, int bookId) {
       
        Member member = findMemberById(memberId);
        if (member == null) {
            System.out.println(" Member not found!");
            return;
        }
        
        if (!member.getBorrowedBookIds().contains(bookId)) {
            System.out.println("❌ This member has not borrowed this book!");
            return;
        }

       
        Book book = findBookById(bookId);
        if (book == null) {
            System.out.println("❌ Book not found!");
            return;
        }

     
        Transaction transaction = findActiveTransaction(memberId, bookId);
        if (transaction == null) {
            System.out.println("❌ Transaction not found!");
            return;
        }

   
        double fine = transaction.calculateFine();

        
        book.markAsReturned();
        member.returnBook(bookId);

        System.out.println("✅ Book returned successfully!");
        System.out.println("📅 Return Date: " + transaction.getReturnDate());
        
        if (fine > 0) {
            System.out.println("💰 Fine: ₹" + fine);
        } else {
            System.out.println("💚 No fine. Book returned on time!");
        }
    }

    private Book findBookById(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                return book;
            }
        }
        return null;
    }


    private Member findMemberById(int memberId) {
        for (Member member : members) {
            if (member.getId() == memberId) {
                return member;
            }
        }
        return null;
    }


    private Transaction findActiveTransaction(int memberId, int bookId) {
        for (Transaction transaction : transactions) {
            if (transaction.getMemberId() == memberId && 
                transaction.getBookId() == bookId && 
                transaction.getReturnDate() == null) {
                return transaction;
            }
        }
        return null;
    }
}