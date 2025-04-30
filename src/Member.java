import java.util.ArrayList;
import java.util.Iterator;

public class Member{
    String name;
    int id;
    ArrayList<Integer> borrowedBooks;

    Member(String name, int id){
        this.name = name;
        this.id = id;
        borrowedBooks = new ArrayList<>();
    }

    int getMaxBorrows(){
        return 3;
    }

    String name(){
        return name;
    }

    int id(){
        return id;
    }

    ArrayList<Integer> borrowedBooks(){
        return borrowedBooks;
    }

    void addBook(int bookId){
        borrowedBooks.add(bookId);
    }

    void printMember(){
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Borrowed books: ");
        for (Integer bookID : borrowedBooks) {
            System.out.println("Book ID: " + bookID);
        }
        System.out.println("Available Borrows: " + (3-borrowedBooks.size()));
    }

    void removeBook(int bookId){
        Iterator<Integer> iterator = borrowedBooks.iterator();
        while(iterator.hasNext()){
            Integer bookID = iterator.next();
            if(bookID == bookId){
                iterator.remove();
                break;
            }
        }
    }

}