import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Biblio {
    private String nomBiblio;
    private List<Book> bookList = new ArrayList<>();

    public Biblio() {
    }

    public Biblio(String nomBiblio, List<Book> bookList) {
        this.nomBiblio = nomBiblio;
        this.bookList = bookList;
    }

    public String getNomBiblio() {
        return nomBiblio;
    }

    public void setNomBiblio(String nomBiblio) {
        this.nomBiblio = nomBiblio;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
    //--------------addBook***
    public void AddBook(Book b)
    {
        bookList.add(b);

    }
    //-----------------showBook**
    public void showBooks(){

        for (Book b:bookList) {
            System.out.println("---------Book "+b.getId()+" ---------");

            System.out.println("Titre : "+b.getTitre());
            System.out.println("Prix : "+b.getPrix());
            System.out.println("Id Auteur : "+b.getAuthor().getId());
            System.out.println("Nom Auteur : "+b.getAuthor().getNom());
            System.out.println("Pays Auteur : "+b.getAuthor().getPays());


        }
    }
    //---------------------- changeBook *****
    public void changeBook(int id,String t,double p,Author a) {

        for (Book b : bookList) {
            if (id == b.getId()) {
                b.setId(id);
                b.setTitre(t);
                b.setPrix(p);
                b.setAuthor(a);
            } else {
                System.out.println("book not found");
            }
        }
    }
    //------------------------------- total****
    public double total(){
        double t = bookList.stream()
                .map(book -> book.getPrix())
                .collect(Collectors.toList())
                .stream()
                .reduce(0.0,Double::sum);
        return t;
    }
    //------------------------------------------searchByPriceSup****
    public List<Book> searchByPriceSup(double p){
        List<Book> books = new ArrayList<>();
        books = bookList.stream()
                .filter(book -> book.getPrix() > p).
                collect(Collectors.toList());
        return books;
    }
    //---------------------searchByAuthorName(String name)---------
    public List<Book> searchByAuthorName(String name){
        List<Book> books = new ArrayList<>();
        books = bookList.stream()
                .filter(book -> book.getAuthor().getNom().contains(name))
                .collect(Collectors.toList());
        return books;
    }


    //-----------------fin-----------------------
}




