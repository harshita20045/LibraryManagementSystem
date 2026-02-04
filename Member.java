import java.util.ArrayList;
import java.util.List;


public class Member implements User {
N
    private int id;
    private String name;
    private String membershipType; 
    private List<Integer> borrowedItemIds; 

    // Constructor
    public Member(int id, String name, String membershipType) {
        this.id = id;
        this.name = name;
        this.membershipType = membershipType;
        this.borrowedItemIds = new ArrayList<>();
    }

  
    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void displayInfo() {
        System.out.println("👤 Member ID: " + id + 
                         " | Name: " + name + 
                         " | Type: " + membershipType +
                         " | Items Borrowed: " + borrowedItemIds.size() + "/" + getMaxBorrowLimit());
    }

    @Override
    public boolean canBorrowItem() {
        return borrowedItemIds.size() < getMaxBorrowLimit();
    }

    public String getMembershipType() {
        return membershipType;
    }

    public List<Integer> getBorrowedItemIds() {
        return borrowedItemIds;
    }

   
    public int getMaxBorrowLimit() {
        if (membershipType.equals("Premium")) {
            return 5; 
        } else {
            return 3; 
        }
    }


    public void borrowItem(int itemId) {
        borrowedItemIds.add(itemId);
    }

    public void returnItem(int itemId) {
        borrowedItemIds.remove(Integer.valueOf(itemId));
    }

    @Override
    public String toString() {
        return "Member ID: " + id + 
               " | Name: " + name + 
               " | Type: " + membershipType +
               " | Items Borrowed: " + borrowedItemIds.size() + "/" + getMaxBorrowLimit();
    }
}