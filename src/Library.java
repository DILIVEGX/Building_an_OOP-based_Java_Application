import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Member> members = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    void addBook() {
        System.out.println("\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the book: ");
        String name = scanner.nextLine();
        System.out.print("Enter the author of the book: ");
        String author = scanner.nextLine();
        System.out.print("Enter the ISBN of the book: ");
        String isbn = scanner.nextLine();
        int maxId = 0;
        for (Book book : books) {
            if (book.id() > maxId) {
                maxId = book.id();
            }
        }
        maxId++;
        System.out.print("1) Book  2) EBook ");
        int ebook = scanner.nextInt();
        if (ebook == 1) {
            books.add(new Book(name, author, isbn, maxId));
            System.out.print("Enter the availability of the book: ");
            books.getLast().setAvailability(scanner.nextInt());
        }else if (ebook == 2) {
            System.out.print("Enter the file format of the Ebook: ");
            scanner.nextLine();
            String fileFormat = scanner.nextLine();
            System.out.print("Enter the file size of the Ebook: EX(352KB or 1.2MB) ");
            String fileSize = scanner.nextLine();
            books.add(new EBook(name, author, isbn, maxId, fileFormat, fileSize));
        }
    }

    void addMember() {
        System.out.println("\n");
        System.out.print("Enter the name of the new member: ");
        String name = scanner.nextLine();
        int type = 0;
        while(type != 1 && type != 2) {
            System.out.print("Is the member 1)Regular 2)Premium: ");
            type = scanner.nextInt();
        }
        int maxId = 0;
        for (Member member : members) {
            if (member.id() > maxId) {
                maxId = member.id();
            }
        }
        maxId++;
        if (type == 1) {
            members.add(new Member(name, maxId));
        }else {
            members.add(new PremiumMember(name, maxId));
        }
    }

    void printAllAvailableBooks() {
        System.out.println("\n");
        for (Book book : books) {
            book.printBook();
        }
    }

    void printBooks(){
        System.out.println("\n");
        for (Book book : books) {
            if(!(book instanceof EBook)) {
                book.printBook();
            }
        }
    }

    void printEBooks(){
        System.out.println("\n");
        for (Book book : books) {
            if(book instanceof EBook) {
                book.printBook();
            }
        }
    }

    void printMembers(){
        System.out.println("\n");
        for (Member member : members) {
            member.printMember();
        }
    }

    void borrowBook() {
        Book borrowBook = null;
        Member borrowedMember = null;
        System.out.println("\n");
        System.out.println("Give me the book ID to borrow: ");
        int bookId = scanner.nextInt();
        for (Book book : books) {
            if (book.id() == bookId) {
                if(book instanceof EBook) {
                    System.out.println("This is not a valid book to Borrow");
                }else {
                    if (book.availability() > 0)
                        borrowBook = book;
                    else
                        System.out.println("There is no book available of " + book.title());
                }
            }
        }
        if(borrowBook != null){
            System.out.println("Book: " + borrowBook.title());
            System.out.println("Give me the Member ID to borrow: ");
            int memberId = scanner.nextInt();
            for (Member member : members) {
                if (member.id() == memberId) {
                    borrowedMember = member;
                }
            }
            if(borrowedMember != null) {
                if(borrowedMember.borrowedBooks().size() <= borrowedMember.getMaxBorrows()){
                    borrowedMember.addBook(borrowBook.id());
                    borrowBook.setAvailability(borrowBook.availability()-1);
                    System.out.println("The member " + borrowedMember.name() + " borrowed the book " + borrowBook.title() + " successfully.");
                }
                else{
                    System.out.println("The member " + borrowedMember.name() + " has reached the limit of "+ borrowedMember.getMaxBorrows() +" borrowed books.\n Please return a book.");
                }
            }else{
                System.out.println("Member not found");
            }
        }else{
            System.out.println("Book not found");
        }
    }

    void searchBook() {
        boolean found = false;
        System.out.println("\n");
        System.out.println("Give me the book ID to search: ");
        int bookId = scanner.nextInt();
        for (Book book : books) {
            if (book.id() == bookId) {
                book.printBook();
                found = true;
            }
        }
        if(!found) {
            System.out.println("Book not found");
        }
    }

    void searchMember() {
        boolean found = false;
        System.out.println("\n");
        System.out.println("Give me the member ID to search: ");
        int memberId = scanner.nextInt();
        for (Member member : members) {
            if (member.id() == memberId) {
                member.printMember();
                found = true;
            }
        }
        if(!found) {
            System.out.println("Member not found");
        }
    }

    void returnBook() {
        boolean found = false;
        System.out.println("\n");
        System.out.println("Give me the member ID: ");
        int memberId = scanner.nextInt();
        for (Member member : members) {
            if (member.id() == memberId) {
                member.printMember();
                System.out.println("Give me the book ID to return: ");
                int bookId = scanner.nextInt();
                boolean foundB = false;
                for (Book book : books) {
                    if (book.id() == bookId) {
                        book.setAvailability(book.availability()+1);
                        member.removeBook(book.id());
                        System.out.println("Member " + member.name() + " returned the book " + book.title() + " successfully.");
                        foundB = true;
                    }
                }
                if(!foundB) {
                    System.out.println("Book not found");
                }
                found = true;
            }
        }
        if(!found) {
            System.out.println("Member not found");
        }
    }


}
