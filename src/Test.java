import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Biblio biblio = new Biblio();
        Author author = new Author(1,"AHMED SAFROUI","MAROC");
        Book book1 = new Book(1,"la boite ",150.0,author);
        Book book2 = new Book(2,"test ",100,author);
        Book book3 = new Book(3,"test ",250,author);
        Book book4 = new Book(4,"test ",300,author);
        Book book5 = new Book(5,"test ",100,author);
        biblio.AddBook(book1);
        biblio.AddBook(book2);
        biblio.AddBook(book3);
        biblio.AddBook(book4);
        biblio.AddBook(book5);
        biblio.showBooks();
        System.out.println("total : "+ biblio.total());
        List<Book> books100 =new ArrayList<>();
        books100=biblio.searchByPriceSup(100.0);
        System.out.println("il y a " + books100.size() );
        List<Book> booksAHMED =new ArrayList<>();
        booksAHMED=biblio.searchByAuthorName("AHMED");
        System.out.println("il y a " + booksAHMED.size() );



    }
}
