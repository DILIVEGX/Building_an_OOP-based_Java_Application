public class Book{
    String title;
    String author;
    String ISBN;
    int availability = 0;
    int id;

    Book(String title, String author, String ISBN, int id){
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.id = id;
    }

    String title(){
        return title;
    }

    int availability(){
        return availability;
    }
    int id(){
        return id;
    }
    void setAvailability(int availability){
        this.availability = availability;
    }

    void printBook(){
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + ISBN);
        System.out.println("Availability: " + availability);
    }
}

