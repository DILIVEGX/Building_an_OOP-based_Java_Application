public class PremiumMember extends Member{
    PremiumMember(String name, int id){
        super(name, id);
    }

    @Override
    int getMaxBorrows(){
        return 10;
    }

    @Override
    void printMember(){
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Borrowed books: ");
        for (Integer bookID : borrowedBooks) {
            System.out.println("Book ID: " + bookID);
        }
        System.out.println("Available Borrows: " + (10-borrowedBooks.size()));
        System.out.println("★Premium Member★");
    }

}