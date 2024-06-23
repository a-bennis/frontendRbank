public class Book {
    private int id;
    private String titre;
    private double prix;
    private Author author;

    public Book() {
    }

    public Book(int id, String titre, double prix, Author author) {
        this.id = id;
        this.titre = titre;
        this.prix = prix;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

}
