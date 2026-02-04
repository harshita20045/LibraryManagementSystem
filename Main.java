import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
 
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        
    
        while (true) {
            displayMenu();
            
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            System.out.println(); 
            
            switch (choice) {
                case 1:
                    addBook(library, scanner);
                    break;
                    
                case 2:
                    library.viewAllBooks();
                    break;
                    
                case 3:
                    registerMember(library, scanner);
                    break;
                    
                case 4:
                    library.viewAllMembers();
                    break;
                    
                case 5:
                    borrowBook(library, scanner);
                    break;
                    
                case 6:
                    returnBook(library, scanner);
                    break;
                    
                case 7:
                    System.out.println("👋 Thank you for using Library Management System!");
                    System.out.println("🚪 Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("❌ Invalid choice! Please try again.\n");
            }
        }
    }
    
    
  
    private static void displayMenu() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║   LIBRARY MANAGEMENT SYSTEM - MENU     ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("1. 📖 Add Book");
        System.out.println("2. 📚 View All Books");
        System.out.println("3. 👤 Register Member");
        System.out.println("4. 👥 View All Members");
        System.out.println("5. 📤 Borrow Book");
        System.out.println("6. 📥 Return Book");
        System.out.println("7. 🚪 Exit");
        System.out.println("════════════════════════════════════════");
    }
    

    private static void addBook(Library library, Scanner scanner) {
        System.out.println("📖 ===== ADD NEW BOOK =====");
        
        System.out.print("Enter Book ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();
        
        System.out.print("Enter Book Author: ");
        String author = scanner.nextLine();
        
        library.addBook(id, title, author);
        System.out.println();
    }
    
  
    private static void registerMember(Library library, Scanner scanner) {
        System.out.println("👤 ===== REGISTER NEW MEMBER =====");
        
        System.out.print("Enter Member ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        
        System.out.print("Enter Member Name: ");
        String name = scanner.nextLine();
        
        library.registerMember(id, name);
        System.out.println();
    }

    private static void borrowBook(Library library, Scanner scanner) {
        System.out.println("📤 ===== BORROW BOOK =====");
        
        System.out.print("Enter Member ID: ");
        int memberId = scanner.nextInt();
        
        System.out.print("Enter Book ID: ");
        int bookId = scanner.nextInt();
        
        library.borrowBook(memberId, bookId);
        System.out.println();
    }
    

    private static void returnBook(Library library, Scanner scanner) {
        System.out.println("📥 ===== RETURN BOOK =====");
        
        System.out.print("Enter Member ID: ");
        int memberId = scanner.nextInt();
        
        System.out.print("Enter Book ID: ");
        int bookId = scanner.nextInt();
        
        library.returnBook(memberId, bookId);
        System.out.println();
    }
}