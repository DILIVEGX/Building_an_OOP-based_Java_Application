public class EBook extends Book{
    String fileFormat;
    String fileSize;

    EBook(String title, String author, String ISBN, int id, String fileFormat, String fileSize){
        super(title, author, ISBN, id);
        this.fileFormat = fileFormat;
        this.fileSize = fileSize;
    }

    @Override
    void printBook(){
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + ISBN);
        System.out.println("File Format: " + fileFormat);
        System.out.println("File Size: " + fileSize);
    }
}