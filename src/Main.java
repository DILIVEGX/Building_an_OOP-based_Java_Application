import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to library management system");
        int menu = 0;
        Library library = new Library();
        while (menu != 11) {
            System.out.println("\n");
            System.out.println("1) Add a Book");
            System.out.println("2) Add a Member");
            System.out.println("3) Show all Books");
            System.out.println("4) Show Books");
            System.out.println("5) Show EBooks");
            System.out.println("6) Show Members");
            System.out.println("7) Borrow a Book");
            System.out.println("8) Search Book for ID");
            System.out.println("9) Search Member for ID");
            System.out.println("10) Return Books");
            System.out.println("11) Exit");
            menu = scanner.nextInt();
            scanner.nextLine();
            switch (menu) {
                case 1:
                    library.addBook();
                    break;
                case 2:
                    library.addMember();
                    break;
                case 3:
                    library.printAllAvailableBooks();
                    break;
                case 4:
                    library.printBooks();
                    break;
                case 5:
                    library.printEBooks();
                    break;
                case 6:
                    library.printMembers();
                    break;
                case 7:
                    library.borrowBook();
                    break;
                case 8:
                    library.searchBook();
                    break;
                case 9:
                    library.searchMember();
                    break;
                case 10:
                    library.returnBook();
            }
        }
        scanner.close();
    }
}