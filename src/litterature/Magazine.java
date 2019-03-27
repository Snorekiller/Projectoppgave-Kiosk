package litterature;

public class Magazine extends Litterature{
    private String publisher;

    public Magazine(String title, String publisher, String genre) {
    super (title, genre) ;
    this.publisher = publisher;
    }

    public String getTitle(){
        return super.getTitles();
    }

    public String getPublisher(){
        return publisher;
    }

    public String getGenre() {
        return super.getGenres();
    }
}

